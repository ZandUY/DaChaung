package com.foods.model;
public class YyxcsMsg {
	private Integer id;//ID
	private String title;//标题
	private String fmImg;//封面图
	private String csContent;//常识内容
	private String fbTime;//发布时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title == null ? null : title.trim();
	}
	public String getFmImg(){
		return fmImg;
	}
	public void setFmImg(String fmImg){
		this.fmImg = fmImg == null ? null : fmImg.trim();
	}
	public String getCsContent(){
		return csContent;
	}
	public void setCsContent(String csContent){
		this.csContent = csContent == null ? null : csContent.trim();
	}
	public String getFbTime(){
		return fbTime;
	}
	public void setFbTime(String fbTime){
		this.fbTime = fbTime == null ? null : fbTime.trim();
	}
}
