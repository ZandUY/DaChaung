package com.foods.service.impl;
import java.util.ArrayList;
import java.util.List;
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
public class YyxcsMsgServiceImpl implements YyxcsMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	YyxcsMsgMapper yyxcsMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(YyxcsMsg model,LoginModel login){
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
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
		if(model.getCsContent()==null||model.getCsContent().equals("")){
			return "常识内容为必填属性";
		}
		model.setFbTime(sdf1.format(new Date()));//当前时间格式
		yyxcsMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(YyxcsMsg model,LoginModel login){
		YyxcsMsg preModel = yyxcsMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
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
		if(model.getCsContent()==null||model.getCsContent().equals("")){
			return "常识内容为必填属性";
		}
		preModel.setTitle(model.getTitle());
		preModel.setFmImg(model.getFmImg());
		preModel.setCsContent(model.getCsContent());
		yyxcsMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询营养小常识列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String fbTime1,String fbTime2,YyxcsMsg queryModel,Integer pageSize,LoginModel login) {
		YyxcsMsgExample se = new YyxcsMsgExample();
		YyxcsMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(fbTime1!=null&&fbTime1.equals("")==false){
			sc.andFbTimeGreaterThanOrEqualTo(fbTime1);
		}
		if(fbTime2!=null&&fbTime2.equals("")==false){
			sc.andFbTimeLessThanOrEqualTo(fbTime2);
		}
		int count = (int)yyxcsMsgMapper.countByExample(se);
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
	*根据参数查询营养小常识列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String fbTime1,String fbTime2,YyxcsMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		YyxcsMsgExample se = new YyxcsMsgExample();
		YyxcsMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(fbTime1!=null&&fbTime1.equals("")==false){
			sc.andFbTimeGreaterThanOrEqualTo(fbTime1);
		}
		if(fbTime2!=null&&fbTime2.equals("")==false){
			sc.andFbTimeLessThanOrEqualTo(fbTime2);
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<YyxcsMsg> list = yyxcsMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(YyxcsMsg model:list){
			list2.add(getYyxcsMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装营养小常识为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getYyxcsMsgModel(YyxcsMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("yyxcsMsg",model);
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
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		yyxcsMsgMapper.deleteByPrimaryKey(id);
	}
}
