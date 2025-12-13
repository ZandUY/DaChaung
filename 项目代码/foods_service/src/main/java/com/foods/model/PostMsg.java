package com.foods.model;
public class PostMsg {
	private Integer id;//ID
	private String title;//标题
	private String subtitle;//副标题
	private String postDetail;//帖子详情
	private Integer userId;//用户ID
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
	public String getSubtitle(){
		return subtitle;
	}
	public void setSubtitle(String subtitle){
		this.subtitle = subtitle == null ? null : subtitle.trim();
	}
	public String getPostDetail(){
		return postDetail;
	}
	public void setPostDetail(String postDetail){
		this.postDetail = postDetail == null ? null : postDetail.trim();
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public String getFbTime(){
		return fbTime;
	}
	public void setFbTime(String fbTime){
		this.fbTime = fbTime == null ? null : fbTime.trim();
	}
}
