package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface LmsgSuggestMsgService{
	/**
	分页查询留言反馈数据总数
	*/
	public Map<String,Integer> getDataListCount(LmsgSuggestMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询留言反馈数据列表
	*/
	public Map<String,Object> getDataList(LmsgSuggestMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装留言反馈为前台展示的数据形式
	*/
	public Map<String,Object> getLmsgSuggestMsgModel(LmsgSuggestMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(LmsgSuggestMsg model,LoginModel login);
	/**
	回复
	*/
	public String hf(LmsgSuggestMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(LmsgSuggestMsg model,LoginModel login);
}
