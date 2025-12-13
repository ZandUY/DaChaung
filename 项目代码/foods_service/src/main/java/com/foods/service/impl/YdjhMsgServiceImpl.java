package com.foods.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foods.dao.*;
import com.foods.model.*;
import com.foods.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.foods.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.foods.service.*;
import com.foods.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.io.IOException;
@Service
public class YdjhMsgServiceImpl implements YdjhMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	YdjhMsgMapper ydjhMsgMapper;
	@Autowired
	BmifwMsgMapper bmifwMsgMapper;
	@Autowired
	YdxhfwMsgMapper ydxhfwMsgMapper;
	@Autowired
	YdLogMapper ydLogMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	
	/**
	新增
	*/
	@Override
	public String add(YdjhMsg model,LoginModel login){
		if(model.getJhName()==null||model.getJhName().equals("")){
			return "计划名为必填属性";
		}
		if(model.getFmImg()==null||model.getFmImg().equals("")){
			return "封面图为必填属性";
		}
		if(model.getFmImg()!=null){
			String [] fileSplit = model.getFmImg().split(";");
			if(fileSplit.length>1){
				return "封面图的图片数量不能大于1";
			}
		}
		if(model.getBmifw()==null){
			return "BMI范围为必填属性";
		}
		if(model.getYdxhfw()==null){
			return "运动消耗范围为必填属性";
		}
		if(model.getJhDetail()==null||model.getJhDetail().equals("")){
			return "计划详情为必填属性";
		}
		model.setFbTime(sdf1.format(new Date()));//当前时间格式
		ydjhMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(YdjhMsg model,LoginModel login){
		YdjhMsg preModel = ydjhMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getJhName()==null||model.getJhName().equals("")){
			return "计划名为必填属性";
		}
		if(model.getFmImg()==null||model.getFmImg().equals("")){
			return "封面图为必填属性";
		}
		if(model.getFmImg()!=null){
			String [] fileSplit = model.getFmImg().split(";");
			if(fileSplit.length>1){
				return "封面图的图片数量不能大于1";
			}
		}
		if(model.getBmifw()==null){
			return "BMI范围为必填属性";
		}
		if(model.getYdxhfw()==null){
			return "运动消耗范围为必填属性";
		}
		if(model.getJhDetail()==null||model.getJhDetail().equals("")){
			return "计划详情为必填属性";
		}
		preModel.setJhName(model.getJhName());
		preModel.setFmImg(model.getFmImg());
		preModel.setBmifw(model.getBmifw());
		preModel.setYdxhfw(model.getYdxhfw());
		preModel.setJhDetail(model.getJhDetail());
		ydjhMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询运动计划列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(YdjhMsg queryModel,Integer pageSize,LoginModel login) {
		YdjhMsgExample se = new YdjhMsgExample();
		YdjhMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getJhName()!=null&&queryModel.getJhName().equals("")==false){
			sc.andJhNameLike("%"+queryModel.getJhName()+"%");//模糊查询
		}
		if(queryModel.getBmifw()!=null){
			sc.andBmifwEqualTo(queryModel.getBmifw());//查询BMI范围等于指定值
		}
		if(queryModel.getYdxhfw()!=null){
			sc.andYdxhfwEqualTo(queryModel.getYdxhfw());//查询运动消耗范围等于指定值
		}
		
		if(login.getLoginType()==2) {
			YdLogExample le = new YdLogExample();
			YdLogExample.Criteria lc  = le.createCriteria();
			lc.andUserIdEqualTo(login.getId());
			List<YdLog> ll = ydLogMapper.selectByExample(le);
			Set<String> dates = new HashSet<String>();
			int total = 0;
			for(YdLog l:ll) {
				dates.add(l.getYdDate());
				total+=l.getZrNum();
			}
			if(dates.size()>0) {
				total = total/dates.size();//平均每日热量
			}
			
			YdxhfwMsgExample ye = new YdxhfwMsgExample();
			YdxhfwMsgExample.Criteria yc = ye.createCriteria();
			yc.andMinLessThanOrEqualTo(total+0.0);
			yc.andMaxGreaterThanOrEqualTo(total+0.0);
			List<YdxhfwMsg> yl = ydxhfwMsgMapper.selectByExample(ye);
			List<Integer> yids = new ArrayList<Integer>();
			for(YdxhfwMsg b:yl) {
				yids.add(b.getId());
			}
			
			UserMsg u = userMsgMapper.selectByPrimaryKey(login.getId());
			BmifwMsgExample be = new BmifwMsgExample();
			BmifwMsgExample.Criteria bc = be.createCriteria();
			bc.andMinLessThanOrEqualTo(u.getBmi());
			bc.andMaxGreaterThanOrEqualTo(u.getBmi());
			List<BmifwMsg> bl = bmifwMsgMapper.selectByExample(be);
			List<Integer> bids = new ArrayList<Integer>();
			for(BmifwMsg b:bl) {
				bids.add(b.getId());
			}
			
			if(yids.size()>0) {
				sc.andYdxhfwIn(yids);
			}else {
				sc.andIdEqualTo(0);
			}
			if(bids.size()>0) {
				sc.andBmifwIn(bids);
			}else {
				sc.andIdEqualTo(0);
			}
					
		}
		int count = (int)ydjhMsgMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询运动计划列表数据
	*/
	@Override
	public Map<String,Object> getDataList(YdjhMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		YdjhMsgExample se = new YdjhMsgExample();
		YdjhMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getJhName()!=null&&queryModel.getJhName().equals("")==false){
			sc.andJhNameLike("%"+queryModel.getJhName()+"%");//模糊查询
		}
		if(queryModel.getBmifw()!=null){
			sc.andBmifwEqualTo(queryModel.getBmifw());//查询BMI范围等于指定值
		}
		if(queryModel.getYdxhfw()!=null){
			sc.andYdxhfwEqualTo(queryModel.getYdxhfw());//查询运动消耗范围等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		
		if(login.getLoginType()==2) {
			YdLogExample le = new YdLogExample();
			YdLogExample.Criteria lc  = le.createCriteria();
			lc.andUserIdEqualTo(login.getId());
			List<YdLog> ll = ydLogMapper.selectByExample(le);
			Set<String> dates = new HashSet<String>();
			int total = 0;
			for(YdLog l:ll) {
				dates.add(l.getYdDate());
				total+=l.getZrNum();
			}
			if(dates.size()>0) {
				total = total/dates.size();//平均每日热量
			}
			
			YdxhfwMsgExample ye = new YdxhfwMsgExample();
			YdxhfwMsgExample.Criteria yc = ye.createCriteria();
			yc.andMinLessThanOrEqualTo(total+0.0);
			yc.andMaxGreaterThanOrEqualTo(total+0.0);
			List<YdxhfwMsg> yl = ydxhfwMsgMapper.selectByExample(ye);
			List<Integer> yids = new ArrayList<Integer>();
			for(YdxhfwMsg b:yl) {
				yids.add(b.getId());
			}
			
			UserMsg u = userMsgMapper.selectByPrimaryKey(login.getId());
			BmifwMsgExample be = new BmifwMsgExample();
			BmifwMsgExample.Criteria bc = be.createCriteria();
			bc.andMinLessThanOrEqualTo(u.getBmi());
			bc.andMaxGreaterThanOrEqualTo(u.getBmi());
			List<BmifwMsg> bl = bmifwMsgMapper.selectByExample(be);
			List<Integer> bids = new ArrayList<Integer>();
			for(BmifwMsg b:bl) {
				bids.add(b.getId());
			}
			
			if(yids.size()>0) {
				sc.andYdxhfwIn(yids);
			}else {
				sc.andIdEqualTo(0);
			}
			if(bids.size()>0) {
				sc.andBmifwIn(bids);
			}else {
				sc.andIdEqualTo(0);
			}
					
		}
		List<YdjhMsg> list = ydjhMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(YdjhMsg model:list){
			list2.add(getYdjhMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装运动计划为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getYdjhMsgModel(YdjhMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ydjhMsg",model);
		List<String> fmImgList = new ArrayList<String>();
		if(model.getFmImg()!=null){
			String [] fmImgSplit = model.getFmImg().split(";");
			for(String tmpstr:fmImgSplit ){
				if(tmpstr.equals("")==false){
					fmImgList.add(tmpstr);
				}
			}
		}
		map.put("fmImgList",fmImgList);
		if(model.getBmifw()!=null){
			BmifwMsg bmifwMsg = bmifwMsgMapper.selectByPrimaryKey(model.getBmifw());//BMI范围为外接字段，需要关联BMI范围来解释该字段
			map.put("bmifwMsg",bmifwMsg);
			if(bmifwMsg!=null){
				map.put("bmifwStr",bmifwMsg.getFwName());
			}
		}
		if(model.getYdxhfw()!=null){
			YdxhfwMsg ydxhfwMsg = ydxhfwMsgMapper.selectByPrimaryKey(model.getYdxhfw());//运动消耗范围为外接字段，需要关联运动消耗范围来解释该字段
			map.put("ydxhfwMsg",ydxhfwMsg);
			if(ydxhfwMsg!=null){
				map.put("ydxhfwStr",ydxhfwMsg.getFwName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		ydjhMsgMapper.deleteByPrimaryKey(id);
	}
}
