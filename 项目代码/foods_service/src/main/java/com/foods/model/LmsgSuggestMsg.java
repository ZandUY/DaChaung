package com.foods.model;
public class LmsgSuggestMsg {
	private Integer id;//ID
	private String title;//标题
	private String lmsgContent;//留言内容
	private String lmsgImg;//留言附图
	private Integer userId;//用户ID
	private Integer lmsgStatus;//留言状态
	private String replyContent;//回复内容
	private String lmsgTime;//留言时间
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
	public String getLmsgContent(){
		return lmsgContent;
	}
	public void setLmsgContent(String lmsgContent){
		this.lmsgContent = lmsgContent == null ? null : lmsgContent.trim();
	}
	public String getLmsgImg(){
		return lmsgImg;
	}
	public void setLmsgImg(String lmsgImg){
		this.lmsgImg = lmsgImg == null ? null : lmsgImg.trim();
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getLmsgStatus(){
		return lmsgStatus;
	}
	public void setLmsgStatus(Integer lmsgStatus){
		this.lmsgStatus = lmsgStatus;
	}
	public String getReplyContent(){
		return replyContent;
	}
	public void setReplyContent(String replyContent){
		this.replyContent = replyContent == null ? null : replyContent.trim();
	}
	public String getLmsgTime(){
		return lmsgTime;
	}
	public void setLmsgTime(String lmsgTime){
		this.lmsgTime = lmsgTime == null ? null : lmsgTime.trim();
	}
}
