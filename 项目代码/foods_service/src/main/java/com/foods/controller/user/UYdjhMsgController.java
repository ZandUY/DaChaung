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
@RequestMapping("/user/ydjh_msg")
public class UYdjhMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	YdjhMsgService ydjhMsgService;
	@Autowired
	YdjhMsgMapper ydjhMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	BmifwMsgMapper bmifwMsgMapper;
	@Autowired
	YdxhfwMsgMapper ydxhfwMsgMapper;
	public void getList(Map<String,Object> rs ,LoginModel login,YdjhMsg model){
		BmifwMsgExample bmifwMsgE = new BmifwMsgExample();
		List<BmifwMsg> bmifwMsgList=bmifwMsgMapper.selectByExample(bmifwMsgE);
		List<Map<String,Object>>  bmifwMsgList2 = new ArrayList<Map<String,Object>>();
		for(BmifwMsg m:bmifwMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getFwName());
			bmifwMsgList2.add(map);
		}
		rs.put("bmifwMsgList",bmifwMsgList2);
		YdxhfwMsgExample ydxhfwMsgE = new YdxhfwMsgExample();
		List<YdxhfwMsg> ydxhfwMsgList=ydxhfwMsgMapper.selectByExample(ydxhfwMsgE);
		List<Map<String,Object>>  ydxhfwMsgList2 = new ArrayList<Map<String,Object>>();
		for(YdxhfwMsg m:ydxhfwMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getFwName());
			ydxhfwMsgList2.add(map);
		}
		rs.put("ydxhfwMsgList",ydxhfwMsgList2);
	}
	/**
	* 根据查询条件分页查询运动计划数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(YdjhMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ydjhMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		YdjhMsg ydjhMsg = ydjhMsgMapper.selectByPrimaryKey(id);
		return ydjhMsg;
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
	* 根据查询条件分页查询运动计划数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(YdjhMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return ydjhMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
}
