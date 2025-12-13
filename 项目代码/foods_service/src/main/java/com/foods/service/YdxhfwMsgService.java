package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface YdxhfwMsgService{
	/**
	分页查询运动消耗范围数据总数
	*/
	public Map<String,Integer> getDataListCount(YdxhfwMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询运动消耗范围数据列表
	*/
	public Map<String,Object> getDataList(YdxhfwMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装运动消耗范围为前台展示的数据形式
	*/
	public Map<String,Object> getYdxhfwMsgModel(YdxhfwMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(YdxhfwMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(YdxhfwMsg model,LoginModel login);
}
