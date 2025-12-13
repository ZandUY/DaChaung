package com.foods.model;
public class YsCollectMsg {
	private Integer id;//ID
	private Integer ysjh;//饮食计划
	private Integer userId;//用户ID
	private String collectTime;//收藏时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getYsjh(){
		return ysjh;
	}
	public void setYsjh(Integer ysjh){
		this.ysjh = ysjh;
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
