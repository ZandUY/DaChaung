package com.foods.model;
public class YsjhMsg {
	private Integer id;//ID
	private String jhName;//计划名
	private String fmImg;//封面图
	private Integer bmifw;//BMI范围
	private Integer ynumFw;//饮食热量范围
	private String jhDetail;//计划详情
	private String fbTime;//发布时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getJhName(){
		return jhName;
	}
	public void setJhName(String jhName){
		this.jhName = jhName == null ? null : jhName.trim();
	}
	public String getFmImg(){
		return fmImg;
	}
	public void setFmImg(String fmImg){
		this.fmImg = fmImg == null ? null : fmImg.trim();
	}
	public Integer getBmifw(){
		return bmifw;
	}
	public void setBmifw(Integer bmifw){
		this.bmifw = bmifw;
	}
	public Integer getYnumFw(){
		return ynumFw;
	}
	public void setYnumFw(Integer ynumFw){
		this.ynumFw = ynumFw;
	}
	public String getJhDetail(){
		return jhDetail;
	}
	public void setJhDetail(String jhDetail){
		this.jhDetail = jhDetail == null ? null : jhDetail.trim();
	}
	public String getFbTime(){
		return fbTime;
	}
	public void setFbTime(String fbTime){
		this.fbTime = fbTime == null ? null : fbTime.trim();
	}
}
