package com.foods.model;
public class UserMsg {
	private Integer id;//ID
	private String loginName;//登录名
	private String password;//密码
	private String name;//姓名
	private String celphone;//联系电话
	private String email;//邮箱
	private Integer sex;//性别
	private Integer sg;//身高
	private Double weight;//体重
	private Double bmi;//BMI
	private String age;//年龄
	private String headImg;//头像
	private String zcTime;//注册时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setLoginName(String loginName){
		this.loginName = loginName == null ? null : loginName.trim();
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password == null ? null : password.trim();
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name == null ? null : name.trim();
	}
	public String getCelphone(){
		return celphone;
	}
	public void setCelphone(String celphone){
		this.celphone = celphone == null ? null : celphone.trim();
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email == null ? null : email.trim();
	}
	public Integer getSex(){
		return sex;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public Integer getSg(){
		return sg;
	}
	public void setSg(Integer sg){
		this.sg = sg;
	}
	public Double getWeight(){
		return weight;
	}
	public void setWeight(Double weight){
		this.weight = weight;
	}
	public Double getBmi(){
		return bmi;
	}
	public void setBmi(Double bmi){
		this.bmi = bmi;
	}
	public String getAge(){
		return age;
	}
	public void setAge(String age){
		this.age = age == null ? null : age.trim();
	}
	public String getHeadImg(){
		return headImg;
	}
	public void setHeadImg(String headImg){
		this.headImg = headImg == null ? null : headImg.trim();
	}
	public String getZcTime(){
		return zcTime;
	}
	public void setZcTime(String zcTime){
		this.zcTime = zcTime == null ? null : zcTime.trim();
	}
}
