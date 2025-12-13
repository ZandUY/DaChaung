package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface BmifwMsgService{
	/**
	分页查询BMI范围数据总数
	*/
	public Map<String,Integer> getDataListCount(BmifwMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询BMI范围数据列表
	*/
	public Map<String,Object> getDataList(BmifwMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装BMI范围为前台展示的数据形式
	*/
	public Map<String,Object> getBmifwMsgModel(BmifwMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(BmifwMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(BmifwMsg model,LoginModel login);
}
