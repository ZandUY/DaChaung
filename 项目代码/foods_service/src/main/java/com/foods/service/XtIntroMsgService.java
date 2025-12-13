package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface XtIntroMsgService{
	/**
	分页查询系统介绍数据总数
	*/
	public Map<String,Integer> getDataListCount(XtIntroMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询系统介绍数据列表
	*/
	public Map<String,Object> getDataList(XtIntroMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装系统介绍为前台展示的数据形式
	*/
	public Map<String,Object> getXtIntroMsgModel(XtIntroMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(XtIntroMsg model,LoginModel login);
}
