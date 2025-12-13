package com.foods.model;
public class DisMsg {
	private Integer id;//ID
	private Integer postId;//帖子ID
	private String disContent;//评论内容
	private Integer userId;//用户ID
	private String disTime;//评论时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getPostId(){
		return postId;
	}
	public void setPostId(Integer postId){
		this.postId = postId;
	}
	public String getDisContent(){
		return disContent;
	}
	public void setDisContent(String disContent){
		this.disContent = disContent == null ? null : disContent.trim();
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public String getDisTime(){
		return disTime;
	}
	public void setDisTime(String disTime){
		this.disTime = disTime == null ? null : disTime.trim();
	}
}
