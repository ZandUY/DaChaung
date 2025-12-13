package com.foods.model;
public class ReplyMsg {
	private Integer id;//ID
	private Integer disId;//评论ID
	private String replyContent;//回复内容
	private Integer userId;//用户ID
	private String replyTime;//回复时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getDisId(){
		return disId;
	}
	public void setDisId(Integer disId){
		this.disId = disId;
	}
	public String getReplyContent(){
		return replyContent;
	}
	public void setReplyContent(String replyContent){
		this.replyContent = replyContent == null ? null : replyContent.trim();
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public String getReplyTime(){
		return replyTime;
	}
	public void setReplyTime(String replyTime){
		this.replyTime = replyTime == null ? null : replyTime.trim();
	}
}
