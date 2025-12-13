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
public class YdTypeMsgServiceImpl implements YdTypeMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	YdTypeMsgMapper ydTypeMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(YdTypeMsg model,LoginModel login){
		if(model.getTypeName()==null||model.getTypeName().equals("")){
			return "类型名为必填属性";
		}
		if(model.getMfzxh()==null){
			return "每分钟消耗为必填属性";
		}
		ydTypeMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(YdTypeMsg model,LoginModel login){
		YdTypeMsg preModel = ydTypeMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getTypeName()==null||model.getTypeName().equals("")){
			return "类型名为必填属性";
		}
		if(model.getMfzxh()==null){
			return "每分钟消耗为必填属性";
		}
		preModel.setTypeName(model.getTypeName());
		preModel.setMfzxh(model.getMfzxh());
		ydTypeMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询运动类型列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(YdTypeMsg queryModel,Integer pageSize,LoginModel login) {
		YdTypeMsgExample se = new YdTypeMsgExample();
		YdTypeMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTypeName()!=null&&queryModel.getTypeName().equals("")==false){
			sc.andTypeNameLike("%"+queryModel.getTypeName()+"%");//模糊查询
		}
		int count = (int)ydTypeMsgMapper.countByExample(se);
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
	*根据参数查询运动类型列表数据
	*/
	@Override
	public Map<String,Object> getDataList(YdTypeMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		YdTypeMsgExample se = new YdTypeMsgExample();
		YdTypeMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTypeName()!=null&&queryModel.getTypeName().equals("")==false){
			sc.andTypeNameLike("%"+queryModel.getTypeName()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<YdTypeMsg> list = ydTypeMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(YdTypeMsg model:list){
			list2.add(getYdTypeMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装运动类型为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getYdTypeMsgModel(YdTypeMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ydTypeMsg",model);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		ydTypeMsgMapper.deleteByPrimaryKey(id);
	}
}
