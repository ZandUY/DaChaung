package com.foods.controller.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.foods.dao.*;
import com.foods.model.*;
import com.foods.service.impl.*;
import com.foods.util.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.foods.controller.LoginModel;
import com.foods.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user/yd_log")
public class UYdLogController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	YdLogService ydLogService;
	@Autowired
	YdTypeMsgMapper ydTypeMsgMapper;
	@Autowired
	YdLogMapper ydLogMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	public void getList(Map<String,Object> rs ,LoginModel login,YdLog model){
		YdTypeMsgExample ydTypeMsgE = new YdTypeMsgExample();
		List<YdTypeMsg> ydTypeMsgList=ydTypeMsgMapper.selectByExample(ydTypeMsgE);
		List<Map<String,Object>>  ydTypeMsgList2 = new ArrayList<Map<String,Object>>();
		for(YdTypeMsg m:ydTypeMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getTypeName());
			ydTypeMsgList2.add(map);
		}
		rs.put("ydTypeMsgList",ydTypeMsgList2);
		UserMsgExample userMsgE = new UserMsgExample();
		UserMsgExample.Criteria userMsgC=userMsgE.createCriteria();
		userMsgC.andIdEqualTo(login.getId());//ID等于当前登录id
		List<UserMsg> userMsgList=userMsgMapper.selectByExample(userMsgE);
		List<Map<String,Object>>  userMsgList2 = new ArrayList<Map<String,Object>>();
		for(UserMsg m:userMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getLoginName());
			userMsgList2.add(map);
		}
		rs.put("userMsgList",userMsgList2);
	}
	/**
	* 根据查询条件分页查询运动记录数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(YdLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ydLogService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		YdLog ydLog = ydLogMapper.selectByPrimaryKey(id);
		return ydLog;
	}
	/**
	* 查询页面所需要的数据
	*/
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(String loginToken,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		rs.put("user",userMsg);
		getList( rs,login,null);//获取数据列表并返回给前台
		return rs;
	}
	/**
	* 根据查询条件分页查询运动记录数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(YdLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ydLogService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(YdLog model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = ydLogService.add(model,login);//执行添加操作
		if(msg.equals("")==false){
			rs.put("code",0);
			rs.put("msg",msg);
			return rs;
		}
		rs.put("code",1);
		rs.put("msg","新增成功");
		return rs;
	}
	/**
	删除运动记录接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		ydLogService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(YdLog model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = ydLogService.update(model,login);//执行修改操作
		if(msg.equals("")==false){
			rs.put("code",0);
			rs.put("msg",msg);
			return rs;
		}
		rs.put("code",1);
		rs.put("msg","修改成功");
		return rs;
	}
}
