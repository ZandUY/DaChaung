package com.foods.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import com.foods.dao.*;
import com.foods.model.*;
import com.foods.service.*;
import com.foods.controller.*;
import com.foods.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/home")
public class HomeGatherController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YdCollectMsgMapper ydCollectMsgMapper;
	@Autowired
	YsCollectMsgMapper ysCollectMsgMapper;
	@Autowired
	PostMsgMapper postMsgMapper;
	@Autowired
	YsTypeMsgMapper ysTypeMsgMapper;
	@Autowired
	YdTypeMsgMapper ydTypeMsgMapper;
	@Autowired
	YdLogMapper ydLogMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	YsLogMapper ysLogMapper;
	@RequestMapping(value="getHomeMsg")
	@ResponseBody
	public Object getHomeMsg(HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		if(login==null){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		String today = sdf2.format(new Date());
		//
		//查询用户数
		UserMsgExample de1 = new UserMsgExample();
		List<UserMsg> dl1 = userMsgMapper.selectByExample(de1);
		rs.put("data1",dl1.size());
		//
		//查询帖子数
		PostMsgExample de2 = new PostMsgExample();
		List<PostMsg> dl2 = postMsgMapper.selectByExample(de2);
		rs.put("data2",dl2.size());
		//
		//查询饮食收藏数
		YsCollectMsgExample de3 = new YsCollectMsgExample();
		List<YsCollectMsg> dl3 = ysCollectMsgMapper.selectByExample(de3);
		rs.put("data3",dl3.size());
		//
		//查询运动收藏数
		YdCollectMsgExample de4 = new YdCollectMsgExample();
		List<YdCollectMsg> dl4 = ydCollectMsgMapper.selectByExample(de4);
		rs.put("data4",dl4.size());
		//
		//查询注册统计
		UserMsgExample de5 = new UserMsgExample();
		UserMsgExample.Criteria dc5 = de5.createCriteria();
		dc5.andZcTimeLike(today.split("-")[0]+"%");//本年
		List<UserMsg> dl5 = userMsgMapper.selectByExample(de5);
		List<Map<String,Object>> dlist5 = new ArrayList<Map<String,Object>>();
		String startDate5 = CommonUtils.getDiffDate(today,-365,sdf2,3);//起始日期是365天前
		List<String> allDate5 = DateCommonUtils.getEchartTimeList(startDate5, today, "yyyy-MM-dd", "yyyy-MM", 2);//查询范围内的所有月份集合
		for(String date:allDate5){
			Integer  value  = 0;//数量
			for(UserMsg d:dl5){
				if(d.getZcTime()==null){
					continue;
				}
				if(d.getZcTime().contains(date)){
					value++;
				}
			}
			Map<String,Object> map =  new HashMap<String,Object>();
			map.put("title",date);
			map.put("value",value);
			dlist5.add(map);
		}
		rs.put("data5",dlist5);
		//
		//查询性别统计
		UserMsgExample de6 = new UserMsgExample();
		List<UserMsg> dl6 = userMsgMapper.selectByExample(de6);
		List<Map<String,Object>> dlist6 = DataListUtils.getSexList();
		for(Map<String,Object> map:dlist6){
			Integer  value  = 0;
			for(UserMsg d:dl6){
				if(map.get("id").toString().equals(d.getSex()+"")){
					value++;
				}
			}
			map.put("title",map.get("name").toString());
			map.put("value",value);
		}
		rs.put("data6",dlist6);
		rs.put("code",1);
		rs.put("msg","请求成功");
		return rs;
	}
	@RequestMapping(value="getHome2Msg")
	@ResponseBody
	public Object getHome2Msg(HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		if(login==null){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		String today = sdf2.format(new Date());
		//
		//查询运动日统计
		YdLogExample de1 = new YdLogExample();
		YdLogExample.Criteria dc1 = de1.createCriteria();
		if(login.getLoginType()==2){
			dc1.andUserIdEqualTo(login.getId());//查询权限限制
		}
		List<YdLog> dl1 = ydLogMapper.selectByExample(de1);
		List<Map<String,Object>> dlist1 = new ArrayList<Map<String,Object>>();
		String startDate1 = CommonUtils.getDiffDate(today,-7,sdf2,3);//起始日期是7天前
		List<String> allDate1 = DateCommonUtils.getEchartTimeList(startDate1, today, "yyyy-MM-dd", "yyyy-MM-dd", 3);//查询范围内的所有日期集合
		for(String date:allDate1){
			Integer  value  = 0;//总热量
			for(YdLog d:dl1){
				if(d.getYdDate()==null){
					continue;
				}
				if(d.getYdDate().contains(date)){
					if(d.getZrNum()!=null){
						value+=d.getZrNum();
					}else{
						continue;
					}
				}
			}
			Map<String,Object> map =  new HashMap<String,Object>();
			map.put("title",date);
			map.put("value",value);
			dlist1.add(map);
		}
		rs.put("data1",dlist1);
		//
		//查询运动类型统计
		YdLogExample de2 = new YdLogExample();
		YdLogExample.Criteria dc2 = de2.createCriteria();
		if(login.getLoginType()==2){
			dc2.andUserIdEqualTo(login.getId());//查询权限限制
		}
		List<YdLog> dl2 = ydLogMapper.selectByExample(de2);
		YdTypeMsgExample ce2 = new YdTypeMsgExample();//关联表“运动类型”信息查询
		List<YdTypeMsg> cl2 = ydTypeMsgMapper.selectByExample(ce2);
		List<Map<String,Object>> dlist2 = new ArrayList<Map<String,Object>>();
		for(YdTypeMsg c:cl2){
			Map<String,Object> map = new HashMap<String,Object>();
			Integer  value  = 0;
			for(YdLog d:dl2){
				if(d.getYdType()==null){
					continue;
				}
				if(d.getYdType().equals(c.getId())){
					value++;
				}
			}
			map.put("title",c.getTypeName());
			map.put("value",value);
			dlist2.add(map);
		}
		rs.put("data2",dlist2);
		//
		//查询饮食类型统计
		YsLogExample de3 = new YsLogExample();
		YsLogExample.Criteria dc3 = de3.createCriteria();
		if(login.getLoginType()==2){
			dc3.andUserIdEqualTo(login.getId());//查询权限限制
		}
		List<YsLog> dl3 = ysLogMapper.selectByExample(de3);
		YsTypeMsgExample ce3 = new YsTypeMsgExample();//关联表“饮食类型”信息查询
		List<YsTypeMsg> cl3 = ysTypeMsgMapper.selectByExample(ce3);
		List<Map<String,Object>> dlist3 = new ArrayList<Map<String,Object>>();
		for(YsTypeMsg c:cl3){
			Map<String,Object> map = new HashMap<String,Object>();
			Integer  value  = 0;
			for(YsLog d:dl3){
				if(d.getYsType()==null){
					continue;
				}
				if(d.getYsType().equals(c.getId())){
					value++;
				}
			}
			map.put("title",c.getTypeName());
			map.put("value",value);
			dlist3.add(map);
		}
		rs.put("data3",dlist3);
		//
		//查询饮食热量日统计
		YsLogExample de4 = new YsLogExample();
		YsLogExample.Criteria dc4 = de4.createCriteria();
		if(login.getLoginType()==2){
			dc4.andUserIdEqualTo(login.getId());//查询权限限制
		}
		List<YsLog> dl4 = ysLogMapper.selectByExample(de4);
		List<Map<String,Object>> dlist4 = new ArrayList<Map<String,Object>>();
		String startDate4 = CommonUtils.getDiffDate(today,-7,sdf2,3);//起始日期是7天前
		List<String> allDate4 = DateCommonUtils.getEchartTimeList(startDate4, today, "yyyy-MM-dd", "yyyy-MM-dd", 3);//查询范围内的所有日期集合
		for(String date:allDate4){
			Integer  value  = 0;//总热量
			for(YsLog d:dl4){
				if(d.getYsDate()==null){
					continue;
				}
				if(d.getYsDate().contains(date)){
					if(d.getZrl()!=null){
						value+=d.getZrl();
					}else{
						continue;
					}
				}
			}
			Map<String,Object> map =  new HashMap<String,Object>();
			map.put("title",date);
			map.put("value",value);
			dlist4.add(map);
		}
		rs.put("data4",dlist4);
		rs.put("code",1);
		rs.put("msg","请求成功");
		return rs;
	}
}
