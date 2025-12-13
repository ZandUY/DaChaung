package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface BannerMsgService{
	/**
	分页查询轮播图数据总数
	*/
	public Map<String,Integer> getDataListCount(BannerMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询轮播图数据列表
	*/
	public Map<String,Object> getDataList(BannerMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装轮播图为前台展示的数据形式
	*/
	public Map<String,Object> getBannerMsgModel(BannerMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(BannerMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(BannerMsg model,LoginModel login);
}
