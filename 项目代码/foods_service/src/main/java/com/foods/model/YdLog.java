package com.foods.model;
public class YdLog {
	private Integer id;//ID
	private String ydDate;//运动日期
	private Integer ydfzs;//运动分钟数
	private Integer ydType;//运动类型
	private Integer mfzxh;//每分钟消耗
	private Integer zrNum;//总热量
	private Integer userId;//用户ID
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getYdDate(){
		return ydDate;
	}
	public void setYdDate(String ydDate){
		this.ydDate = ydDate == null ? null : ydDate.trim();
	}
	public Integer getYdfzs(){
		return ydfzs;
	}
	public void setYdfzs(Integer ydfzs){
		this.ydfzs = ydfzs;
	}
	public Integer getYdType(){
		return ydType;
	}
	public void setYdType(Integer ydType){
		this.ydType = ydType;
	}
	public Integer getMfzxh(){
		return mfzxh;
	}
	public void setMfzxh(Integer mfzxh){
		this.mfzxh = mfzxh;
	}
	public Integer getZrNum(){
		return zrNum;
	}
	public void setZrNum(Integer zrNum){
		this.zrNum = zrNum;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
}
