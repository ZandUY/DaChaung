package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface YsCollectMsgService{
	/**
	分页查询饮食收藏数据总数
	*/
	public Map<String,Integer> getDataListCount(String collectTime1,String collectTime2,YsCollectMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询饮食收藏数据列表
	*/
	public Map<String,Object> getDataList(String collectTime1,String collectTime2,YsCollectMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装饮食收藏为前台展示的数据形式
	*/
	public Map<String,Object> getYsCollectMsgModel(YsCollectMsg model,LoginModel login);
}
