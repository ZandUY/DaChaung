package com.foods.service;
import java.util.Map;
import com.foods.controller.LoginModel;
import com.foods.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface ReplyMsgService{
	/**
	分页查询回复数据总数
	*/
	public Map<String,Integer> getDataListCount(String replyTime1,String replyTime2,ReplyMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询回复数据列表
	*/
	public Map<String,Object> getDataList(String replyTime1,String replyTime2,ReplyMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装回复为前台展示的数据形式
	*/
	public Map<String,Object> getReplyMsgModel(ReplyMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
