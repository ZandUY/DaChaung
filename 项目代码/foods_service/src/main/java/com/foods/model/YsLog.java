package com.foods.model;
public class YsLog {
	private Integer id;//ID
	private String ysDate;//饮食日期
	private Integer ysTime;//饮食时间
	private Integer ysType;//饮食类型
	private Integer mqkrNum;//每千克热量
	private Integer userId;//用户ID
	private Integer zrl;//总热量
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getYsDate(){
		return ysDate;
	}
	public void setYsDate(String ysDate){
		this.ysDate = ysDate == null ? null : ysDate.trim();
	}
	public Integer getYsTime(){
		return ysTime;
	}
	public void setYsTime(Integer ysTime){
		this.ysTime = ysTime;
	}
	public Integer getYsType(){
		return ysType;
	}
	public void setYsType(Integer ysType){
		this.ysType = ysType;
	}
	public Integer getMqkrNum(){
		return mqkrNum;
	}
	public void setMqkrNum(Integer mqkrNum){
		this.mqkrNum = mqkrNum;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getZrl(){
		return zrl;
	}
	public void setZrl(Integer zrl){
		this.zrl = zrl;
	}
}
