package com.foods.model;
public class YdxhfwMsg {
	private Integer id;//ID
	private String fwName;//范围名
	private Double min;//最小值
	private Double max;//最大值
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getFwName(){
		return fwName;
	}
	public void setFwName(String fwName){
		this.fwName = fwName == null ? null : fwName.trim();
	}
	public Double getMin(){
		return min;
	}
	public void setMin(Double min){
		this.min = min;
	}
	public Double getMax(){
		return max;
	}
	public void setMax(Double max){
		this.max = max;
	}
}
