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
public class YdLogServiceImpl implements YdLogService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	YdTypeMsgMapper ydTypeMsgMapper;
	@Autowired
	YdLogMapper ydLogMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(YdLog model,LoginModel login){
		if(model.getYdDate()==null||model.getYdDate().equals("")){
			return "运动日期为必填属性";
		}
		if(model.getYdfzs()==null){
			return "运动分钟数为必填属性";
		}
		if(model.getYdType()==null){
			return "运动类型为必填属性";
		}
		if(model.getZrNum()==null){
			return "总热量为必填属性";
		}
		model.setUserId(login.getId());//登录id
		YdTypeMsg ydTypeT = ydTypeMsgMapper.selectByPrimaryKey(model.getYdType());//查询运动类型
		if(ydTypeT!=null){
			model.setMfzxh(ydTypeT.getMfzxh());//赋值ydTypeT的每分钟消耗
		}
		String today = sdf2.format(new Date());
		ydLogMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(YdLog model,LoginModel login){
		YdLog preModel = ydLogMapper.selectByPrimaryKey(model.getId());
		if(model.getYdDate()==null||model.getYdDate().equals("")){
			return "运动日期为必填属性";
		}
		if(model.getYdfzs()==null){
			return "运动分钟数为必填属性";
		}
		if(model.getYdType()==null){
			return "运动类型为必填属性";
		}
		if(model.getZrNum()==null){
			return "总热量为必填属性";
		}
		preModel.setYdDate(model.getYdDate());
		preModel.setYdfzs(model.getYdfzs());
		preModel.setYdType(model.getYdType());
		preModel.setZrNum(model.getZrNum());
		YdTypeMsg ydTypeT = ydTypeMsgMapper.selectByPrimaryKey(model.getYdType());//查询运动类型
		if(ydTypeT!=null){
			preModel.setMfzxh(ydTypeT.getMfzxh());//赋值ydTypeT的每分钟消耗
		}
		String today = sdf2.format(new Date());
		ydLogMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询运动记录列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(YdLog queryModel,Integer pageSize,LoginModel login) {
		YdLogExample se = new YdLogExample();
		YdLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getYdType()!=null){
			sc.andYdTypeEqualTo(queryModel.getYdType());//查询运动类型等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());//查询用户ID等于指定值
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)ydLogMapper.countByExample(se);
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
	*根据参数查询运动记录列表数据
	*/
	@Override
	public Map<String,Object> getDataList(YdLog queryModel,Integer page,Integer pageSize,LoginModel login) {
		YdLogExample se = new YdLogExample();
		YdLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getYdType()!=null){
			sc.andYdTypeEqualTo(queryModel.getYdType());//查询运动类型等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());//查询用户ID等于指定值
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<YdLog> list = ydLogMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(YdLog model:list){
			list2.add(getYdLogModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装运动记录为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getYdLogModel(YdLog model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ydLog",model);
		if(model.getYdType()!=null){
			YdTypeMsg ydTypeMsg = ydTypeMsgMapper.selectByPrimaryKey(model.getYdType());//运动类型为外接字段，需要关联运动类型来解释该字段
			map.put("ydTypeMsg",ydTypeMsg);
			if(ydTypeMsg!=null){
				map.put("ydTypeStr",ydTypeMsg.getTypeName());
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
		ydLogMapper.deleteByPrimaryKey(id);
	}
}
