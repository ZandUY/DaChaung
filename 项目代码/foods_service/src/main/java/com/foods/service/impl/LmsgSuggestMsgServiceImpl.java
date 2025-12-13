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
public class LmsgSuggestMsgServiceImpl implements LmsgSuggestMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	LmsgSuggestMsgMapper lmsgSuggestMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(LmsgSuggestMsg model,LoginModel login){
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getLmsgContent()==null||model.getLmsgContent().equals("")){
			return "留言内容为必填属性";
		}
		if(model.getLmsgImg()==null||model.getLmsgImg().equals("")){
			return "留言附图为必填属性";
		}
		if(model.getLmsgImg()!=null){
			String [] fileSplit = model.getLmsgImg().split(";");
			if(fileSplit.length>1){
				return "留言附图的图片数量不能大于1";
			}
		}
		model.setUserId(login.getId());//登录id
		model.setLmsgStatus(1);//默认未回复,
		model.setLmsgTime(sdf1.format(new Date()));//当前时间格式
		lmsgSuggestMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	回复
	*/
	@Override
	public String hf(LmsgSuggestMsg model,LoginModel login){
		LmsgSuggestMsg preModel = lmsgSuggestMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getReplyContent()==null||model.getReplyContent().equals("")){
			return "回复内容为必填属性";
		}
		preModel.setLmsgStatus(2);//留言状态设置为已回复
		preModel.setReplyContent(model.getReplyContent());
		lmsgSuggestMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(LmsgSuggestMsg model,LoginModel login){
		LmsgSuggestMsg preModel = lmsgSuggestMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getLmsgContent()==null||model.getLmsgContent().equals("")){
			return "留言内容为必填属性";
		}
		if(model.getLmsgImg()==null||model.getLmsgImg().equals("")){
			return "留言附图为必填属性";
		}
		if(model.getLmsgImg()!=null){
			String [] fileSplit = model.getLmsgImg().split(";");
			if(fileSplit.length>1){
				return "留言附图的图片数量不能大于1";
			}
		}
		preModel.setTitle(model.getTitle());
		preModel.setLmsgContent(model.getLmsgContent());
		preModel.setLmsgImg(model.getLmsgImg());
		lmsgSuggestMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询留言反馈列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(LmsgSuggestMsg queryModel,Integer pageSize,LoginModel login) {
		LmsgSuggestMsgExample se = new LmsgSuggestMsgExample();
		LmsgSuggestMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getLmsgStatus()!=null){
			sc.andLmsgStatusEqualTo(queryModel.getLmsgStatus());//查询留言状态等于指定值
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)lmsgSuggestMsgMapper.countByExample(se);
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
	*根据参数查询留言反馈列表数据
	*/
	@Override
	public Map<String,Object> getDataList(LmsgSuggestMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		LmsgSuggestMsgExample se = new LmsgSuggestMsgExample();
		LmsgSuggestMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getLmsgStatus()!=null){
			sc.andLmsgStatusEqualTo(queryModel.getLmsgStatus());//查询留言状态等于指定值
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<LmsgSuggestMsg> list = lmsgSuggestMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(LmsgSuggestMsg model:list){
			list2.add(getLmsgSuggestMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装留言反馈为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getLmsgSuggestMsgModel(LmsgSuggestMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("lmsgSuggestMsg",model);
		List<String> lmsgImgList = new ArrayList<String>();
		if(model.getLmsgImg()!=null){
			String [] lmsgImgSplit = model.getLmsgImg().split(";");
			for(String tmpstr:lmsgImgSplit ){
				if(tmpstr.equals("")==false){
					lmsgImgList.add(tmpstr);
				}
			}
		}
		map.put("lmsgImgList",lmsgImgList);
		if(model.getUserId()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUserId());//用户ID为外接字段，需要关联用户来解释该字段
			map.put("userMsg",userMsg);
			if(userMsg!=null){
				map.put("userIdStr",userMsg.getLoginName());
				map.put("userIdImg",userMsg.getHeadImg());
			}
		}
		map.put("lmsgStatusStr",DataListUtils.getLmsgStatusNameById(model.getLmsgStatus()+""));//解释留言状态字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		lmsgSuggestMsgMapper.deleteByPrimaryKey(id);
	}
}
