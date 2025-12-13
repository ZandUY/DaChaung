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
@RequestMapping("/user/ys_log")
public class UYsLogController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	YsLogService ysLogService;
	@Autowired
	YsTypeMsgMapper ysTypeMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	YsLogMapper ysLogMapper;
	public void getList(Map<String,Object> rs ,LoginModel login,YsLog model){
		rs.put("ysTimeList",DataListUtils.getYsTimeList());//返回ys_time列表
		YsTypeMsgExample ysTypeMsgE = new YsTypeMsgExample();
		List<YsTypeMsg> ysTypeMsgList=ysTypeMsgMapper.selectByExample(ysTypeMsgE);
		List<Map<String,Object>>  ysTypeMsgList2 = new ArrayList<Map<String,Object>>();
		for(YsTypeMsg m:ysTypeMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getTypeName());
			ysTypeMsgList2.add(map);
		}
		rs.put("ysTypeMsgList",ysTypeMsgList2);
	}
	/**
	* 根据查询条件分页查询饮食记录数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(YsLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ysLogService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		YsLog ysLog = ysLogMapper.selectByPrimaryKey(id);
		return ysLog;
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
	* 根据查询条件分页查询饮食记录数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(YsLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ysLogService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(YsLog model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = ysLogService.add(model,login);//执行添加操作
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
	删除饮食记录接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		ysLogService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(YsLog model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = ysLogService.update(model,login);//执行修改操作
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
