package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface DisMsgService{
	/**
	分页查询评论数据总数
	*/
	public Map<String,Integer> getDataListCount(String disTime1,String disTime2,DisMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询评论数据列表
	*/
	public Map<String,Object> getDataList(String disTime1,String disTime2,DisMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装评论为前台展示的数据形式
	*/
	public Map<String,Object> getDisMsgModel(DisMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
