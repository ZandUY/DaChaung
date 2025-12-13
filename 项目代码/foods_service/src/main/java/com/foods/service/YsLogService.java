package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface YsLogService{
	/**
	分页查询饮食记录数据总数
	*/
	public Map<String,Integer> getDataListCount(YsLog queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询饮食记录数据列表
	*/
	public Map<String,Object> getDataList(YsLog queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装饮食记录为前台展示的数据形式
	*/
	public Map<String,Object> getYsLogModel(YsLog model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(YsLog model,LoginModel login);
	/**
	修改
	*/
	public String update(YsLog model,LoginModel login);
}
