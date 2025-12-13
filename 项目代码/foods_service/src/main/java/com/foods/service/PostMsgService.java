package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface PostMsgService{
	/**
	分页查询帖子数据总数
	*/
	public Map<String,Integer> getDataListCount(PostMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询帖子数据列表
	*/
	public Map<String,Object> getDataList(PostMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装帖子为前台展示的数据形式
	*/
	public Map<String,Object> getPostMsgModel(PostMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(PostMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(PostMsg model,LoginModel login);
}
