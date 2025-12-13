package com.foods.model;
public class YdTypeMsg {
	private Integer id;//ID
	private String typeName;//类型名
	private Integer mfzxh;//每分钟消耗
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
	public Integer getMfzxh(){
		return mfzxh;
	}
	public void setMfzxh(Integer mfzxh){
		this.mfzxh = mfzxh;
	}
}
