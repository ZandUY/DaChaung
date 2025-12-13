package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface YdCollectMsgService{
	/**
	分页查询运动收藏数据总数
	*/
	public Map<String,Integer> getDataListCount(String collectTime1,String collectTime2,YdCollectMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询运动收藏数据列表
	*/
	public Map<String,Object> getDataList(String collectTime1,String collectTime2,YdCollectMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装运动收藏为前台展示的数据形式
	*/
	public Map<String,Object> getYdCollectMsgModel(YdCollectMsg model,LoginModel login);
}
