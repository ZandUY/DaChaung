package com.foods.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.foods.controller.LoginModel;
import org.springframework.web.bind.annotation.ResponseBody;
import com.foods.util.CommonVal;
import  com.foods.model.*;
import com.foods.dao.*;
import com.foods.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/regist")
public class RegistController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	提交注册信息接口
	*/
	@RequestMapping("userMsgRegistSubmit")
	@ResponseBody
	public Object userMsgRegistSubmit(String imgCode,String imgCodeToken,String loginName,String password,String name,String celphone,String email,Integer sex,Integer sg,Double weight,String age,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> rs = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		Cache codeCache = CacheManage.getCacheInfo(imgCodeToken);
		if(codeCache==null){
			rs.put("code",0);
			rs.put("msg","图片验证码错误");
			return rs;
		}
		String imgCode2 = codeCache.getValue().toString();
		if (!imgCode.toLowerCase().equals(imgCode2.toLowerCase())){//当前验证码存储session的值是否和输入的值一致
			rs.put("code",0);
			rs.put("msg", "图片验证码错误");
			return rs;
		}
		if(loginName==null||loginName.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入登录名");
			return rs;
		}
		if(loginName!=null){
			UserMsgExample te=new UserMsgExample();
			UserMsgExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(loginName);
			int count = (int)userMsgMapper.countByExample(te);
			if(count>0){
				rs.put("code",0);
				rs.put("msg",   "该账号已被注册，请用该账号登录");
				return rs;
			}
		}
		if(password==null||password.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入密码");
			return rs;
		}
		if(name==null||name.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入姓名");
			return rs;
		}
		if(celphone==null||celphone.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入联系电话");
			return rs;
		}
		if(celphone!=null&&celphone.trim().equals("")==false){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(celphone);
			if( m.matches()==false){
				;
				rs.put("code",0);
				rs.put("msg",   "请填入正确的联系电话");
				return rs;
			}
		}
		if(email==null||email.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入邮箱");
			return rs;
		}
		if(email!=null&&email.trim().equals("")==false){
		Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(email);
			if( m.matches()==false){
				;
				rs.put("code",0);
				rs.put("msg",   "请填入正确的邮箱");
				return rs;
			}
		}
		if(sex==null){
			rs.put("code",0);
			rs.put("msg",   "请填入性别");
			return rs;
		}
		if(sg==null){
			rs.put("code",0);
			rs.put("msg",   "请填入身高");
			return rs;
		}
		if(weight==null){
			rs.put("code",0);
			rs.put("msg",   "请填入体重");
			return rs;
		}
		if(age==null||age.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入年龄");
			return rs;
		}
		UserMsg model = new UserMsg();
		model.setLoginName(loginName);
		model.setPassword(password);
		model.setName(name);
		model.setCelphone(celphone);
		model.setEmail(email);
		model.setSex(sex);
		model.setSg(sg);
		model.setWeight(weight);
		model.setBmi(0.0);//默认0.0
		model.setAge(age);
		model.setZcTime(sdf1.format(new Date()));//当前时间格式
		userMsgMapper.insertSelective(model);//注册成功，插入该账号进数据库，并返回提示
		rs.put("code",1);
		rs.put("msg",  "注册成功，请使用该账号密码登录");
		return rs;
	}
	@RequestMapping("getListData")
	@ResponseBody
	public Object getListData(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> sexList = DataListUtils.getSexList();
		rs.put("sexList",sexList);
		return rs;
	}
}
