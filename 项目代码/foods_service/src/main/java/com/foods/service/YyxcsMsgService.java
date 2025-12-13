package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface YyxcsMsgService{
	/**
	分页查询营养小常识数据总数
	*/
	public Map<String,Integer> getDataListCount(String fbTime1,String fbTime2,YyxcsMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询营养小常识数据列表
	*/
	public Map<String,Object> getDataList(String fbTime1,String fbTime2,YyxcsMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装营养小常识为前台展示的数据形式
	*/
	public Map<String,Object> getYyxcsMsgModel(YyxcsMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(YyxcsMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(YyxcsMsg model,LoginModel login);
}
