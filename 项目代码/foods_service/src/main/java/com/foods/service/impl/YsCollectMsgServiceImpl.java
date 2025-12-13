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
public class YsCollectMsgServiceImpl implements YsCollectMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	YsjhMsgMapper ysjhMsgMapper;
	@Autowired
	YsCollectMsgMapper ysCollectMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	*根据参数查询饮食收藏列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String collectTime1,String collectTime2,YsCollectMsg queryModel,Integer pageSize,LoginModel login) {
		YsCollectMsgExample se = new YsCollectMsgExample();
		YsCollectMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getYsjh()!=null){
			sc.andYsjhEqualTo(queryModel.getYsjh());//查询饮食计划等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());//查询用户ID等于指定值
		}
		if(collectTime1!=null&&collectTime1.equals("")==false){
			sc.andCollectTimeGreaterThanOrEqualTo(collectTime1);
		}
		if(collectTime2!=null&&collectTime2.equals("")==false){
			sc.andCollectTimeLessThanOrEqualTo(collectTime2);
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)ysCollectMsgMapper.countByExample(se);
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
	*根据参数查询饮食收藏列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String collectTime1,String collectTime2,YsCollectMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		YsCollectMsgExample se = new YsCollectMsgExample();
		YsCollectMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getYsjh()!=null){
			sc.andYsjhEqualTo(queryModel.getYsjh());//查询饮食计划等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());//查询用户ID等于指定值
		}
		if(collectTime1!=null&&collectTime1.equals("")==false){
			sc.andCollectTimeGreaterThanOrEqualTo(collectTime1);
		}
		if(collectTime2!=null&&collectTime2.equals("")==false){
			sc.andCollectTimeLessThanOrEqualTo(collectTime2);
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<YsCollectMsg> list = ysCollectMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(YsCollectMsg model:list){
			list2.add(getYsCollectMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装饮食收藏为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getYsCollectMsgModel(YsCollectMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ysCollectMsg",model);
		if(model.getYsjh()!=null){
			YsjhMsg ysjhMsg = ysjhMsgMapper.selectByPrimaryKey(model.getYsjh());//饮食计划为外接字段，需要关联饮食计划来解释该字段
			map.put("ysjhMsg",ysjhMsg);
			if(ysjhMsg!=null){
				map.put("ysjhStr",ysjhMsg.getJhName());
			}
		}
		if(model.getUserId()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUserId());//用户ID为外接字段，需要关联用户来解释该字段
			map.put("userMsg",userMsg);
			if(userMsg!=null){
				map.put("userIdStr",userMsg.getLoginName());
				map.put("userIdImg",userMsg.getHeadImg());
			}
		}
		return map;
	}
}
