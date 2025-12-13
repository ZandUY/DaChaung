package com.foods.controller.admin;
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
@RequestMapping("/admin/lmsg_suggest_msg")
public class ALmsgSuggestMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	LmsgSuggestMsgService lmsgSuggestMsgService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	LmsgSuggestMsgMapper lmsgSuggestMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	public void getList(Map<String,Object> rs ,LoginModel login,LmsgSuggestMsg model){
		rs.put("lmsgStatusList",DataListUtils.getLmsgStatusList());//返回lmsg_status列表
	}
	/**
	* 根据查询条件分页查询留言反馈数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(LmsgSuggestMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return lmsgSuggestMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		LmsgSuggestMsg lmsgSuggestMsg = lmsgSuggestMsgMapper.selectByPrimaryKey(id);
		return lmsgSuggestMsg;
	}
	/**
	* 查询页面所需要的数据
	*/
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(String loginToken,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		rs.put("user",adminMsg);
		getList( rs,login,null);//获取数据列表并返回给前台
		return rs;
	}
	/**
	* 根据查询条件分页查询留言反馈数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(LmsgSuggestMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return lmsgSuggestMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除留言反馈接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		lmsgSuggestMsgService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	/**
	回复提交信息接口
	*/
	@RequestMapping("hf_submit")
	@ResponseBody
	public Object hf_submit(LmsgSuggestMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = lmsgSuggestMsgService.hf(model,login);//执行修改操作
		if(msg.equals("")==false){
			rs.put("code",0);
			rs.put("msg",msg);
			return rs;
		}
		rs.put("code",1);
		rs.put("msg","回复成功");
		return rs;
	}
}
