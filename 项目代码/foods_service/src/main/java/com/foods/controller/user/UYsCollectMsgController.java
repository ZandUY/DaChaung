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
@RequestMapping("/user/ys_collect_msg")
public class UYsCollectMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	YsCollectMsgService ysCollectMsgService;
	@Autowired
	YsjhMsgMapper ysjhMsgMapper;
	@Autowired
	YsCollectMsgMapper ysCollectMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	public void getList(Map<String,Object> rs ,LoginModel login,YsCollectMsg model){
		YsjhMsgExample ysjhMsgE = new YsjhMsgExample();
		List<YsjhMsg> ysjhMsgList=ysjhMsgMapper.selectByExample(ysjhMsgE);
		List<Map<String,Object>>  ysjhMsgList2 = new ArrayList<Map<String,Object>>();
		for(YsjhMsg m:ysjhMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getJhName());
			ysjhMsgList2.add(map);
		}
		rs.put("ysjhMsgList",ysjhMsgList2);
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
	* 根据查询条件分页查询饮食收藏数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(YsCollectMsg model,Integer page,String collectTime1,String collectTime2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ysCollectMsgService.getDataListCount(collectTime1,collectTime2,model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		YsCollectMsg ysCollectMsg = ysCollectMsgMapper.selectByPrimaryKey(id);
		return ysCollectMsg;
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
	* 根据查询条件分页查询饮食收藏数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(YsCollectMsg model,Integer page,String collectTime1,String collectTime2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ysCollectMsgService.getDataList(collectTime1,collectTime2,model,page,CommonVal.pageSize,login);//分页查询数据
	}
}
