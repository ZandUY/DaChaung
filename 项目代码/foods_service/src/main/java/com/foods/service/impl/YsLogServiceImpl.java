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
public class YsLogServiceImpl implements YsLogService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	YsTypeMsgMapper ysTypeMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	YsLogMapper ysLogMapper;
	/**
	新增
	*/
	@Override
	public String add(YsLog model,LoginModel login){
		if(model.getYsDate()==null||model.getYsDate().equals("")){
			return "饮食日期为必填属性";
		}
		if(model.getYsTime()==null){
			return "饮食时间为必填属性";
		}
		if(model.getYsType()==null){
			return "饮食类型为必填属性";
		}
		model.setUserId(login.getId());//登录id
		model.setZrl(0);//默认0
		YsTypeMsg ysTypeT = ysTypeMsgMapper.selectByPrimaryKey(model.getYsType());//查询饮食类型
		if(ysTypeT!=null){
			model.setMqkrNum(ysTypeT.getMqkrNum());//赋值ysTypeT的每千克热量
		}
		String today = sdf2.format(new Date());
		ysLogMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(YsLog model,LoginModel login){
		YsLog preModel = ysLogMapper.selectByPrimaryKey(model.getId());
		if(model.getYsDate()==null||model.getYsDate().equals("")){
			return "饮食日期为必填属性";
		}
		if(model.getYsTime()==null){
			return "饮食时间为必填属性";
		}
		if(model.getYsType()==null){
			return "饮食类型为必填属性";
		}
		preModel.setYsDate(model.getYsDate());
		preModel.setYsTime(model.getYsTime());
		preModel.setYsType(model.getYsType());
		YsTypeMsg ysTypeT = ysTypeMsgMapper.selectByPrimaryKey(model.getYsType());//查询饮食类型
		if(ysTypeT!=null){
			preModel.setMqkrNum(ysTypeT.getMqkrNum());//赋值ysTypeT的每千克热量
		}
		String today = sdf2.format(new Date());
		ysLogMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询饮食记录列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(YsLog queryModel,Integer pageSize,LoginModel login) {
		YsLogExample se = new YsLogExample();
		YsLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getYsTime()!=null){
			sc.andYsTimeEqualTo(queryModel.getYsTime());//查询饮食时间等于指定值
		}
		if(queryModel.getYsType()!=null){
			sc.andYsTypeEqualTo(queryModel.getYsType());//查询饮食类型等于指定值
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)ysLogMapper.countByExample(se);
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
	*根据参数查询饮食记录列表数据
	*/
	@Override
	public Map<String,Object> getDataList(YsLog queryModel,Integer page,Integer pageSize,LoginModel login) {
		YsLogExample se = new YsLogExample();
		YsLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getYsTime()!=null){
			sc.andYsTimeEqualTo(queryModel.getYsTime());//查询饮食时间等于指定值
		}
		if(queryModel.getYsType()!=null){
			sc.andYsTypeEqualTo(queryModel.getYsType());//查询饮食类型等于指定值
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<YsLog> list = ysLogMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(YsLog model:list){
			list2.add(getYsLogModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装饮食记录为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getYsLogModel(YsLog model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ysLog",model);
		map.put("ysTimeStr",DataListUtils.getYsTimeNameById(model.getYsTime()+""));//解释饮食时间字段
		if(model.getYsType()!=null){
			YsTypeMsg ysTypeMsg = ysTypeMsgMapper.selectByPrimaryKey(model.getYsType());//饮食类型为外接字段，需要关联饮食类型来解释该字段
			map.put("ysTypeMsg",ysTypeMsg);
			if(ysTypeMsg!=null){
				map.put("ysTypeStr",ysTypeMsg.getTypeName());
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
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		ysLogMapper.deleteByPrimaryKey(id);
	}
}
