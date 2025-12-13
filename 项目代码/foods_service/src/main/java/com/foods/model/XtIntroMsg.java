package com.foods.model;
public class XtIntroMsg {
	private Integer id;//ID
	private String title;//标题
	private String fmImg;//封面图
	private String introDetail;//介绍详情
	private String celphone;//联系电话
	private String address;//地址
	private String email;//邮箱
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
	public String getIntroDetail(){
		return introDetail;
	}
	public void setIntroDetail(String introDetail){
		this.introDetail = introDetail == null ? null : introDetail.trim();
	}
	public String getCelphone(){
		return celphone;
	}
	public void setCelphone(String celphone){
		this.celphone = celphone == null ? null : celphone.trim();
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address == null ? null : address.trim();
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email == null ? null : email.trim();
	}
}
