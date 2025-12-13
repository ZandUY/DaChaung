package com.foods.model;
public class YdCollectMsg {
	private Integer id;//ID
	private Integer ydjh;//运动计划
	private Integer userId;//用户ID
	private String collectTime;//收藏时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getYdjh(){
		return ydjh;
	}
	public void setYdjh(Integer ydjh){
		this.ydjh = ydjh;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public String getCollectTime(){
		return collectTime;
	}
	public void setCollectTime(String collectTime){
		this.collectTime = collectTime == null ? null : collectTime.trim();
	}
}
