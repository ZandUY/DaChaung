package com.foods.model;
public class YsTypeMsg {
	private Integer id;//ID
	private String typeName;//类型名
	private Integer mqkrNum;//每千克热量
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTypeName(){
		return typeName;
	}
	public void setTypeName(String typeName){
		this.typeName = typeName == null ? null : typeName.trim();
	}
	public Integer getMqkrNum(){
		return mqkrNum;
	}
	public void setMqkrNum(Integer mqkrNum){
		this.mqkrNum = mqkrNum;
	}
}
