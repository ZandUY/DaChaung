package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface YdTypeMsgService{
	/**
	分页查询运动类型数据总数
	*/
	public Map<String,Integer> getDataListCount(YdTypeMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询运动类型数据列表
	*/
	public Map<String,Object> getDataList(YdTypeMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装运动类型为前台展示的数据形式
	*/
	public Map<String,Object> getYdTypeMsgModel(YdTypeMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(YdTypeMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(YdTypeMsg model,LoginModel login);
}
