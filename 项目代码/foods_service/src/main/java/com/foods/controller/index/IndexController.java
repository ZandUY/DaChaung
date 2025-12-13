package com.foods.controller.index;
import com.foods.controller.*;
import com.foods.dao.*;
import com.foods.model.*;
import com.foods.service.*;
import com.foods.util.*;
import com.foods.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.DecimalFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import java.text.DecimalFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("index")
public class IndexController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	UserMsgMapper userMsgMapper;
	//饮食健康服务平台
	@RequestMapping(value = "getData")
	@ResponseBody
	public Object index(HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs =  new HashMap<String,Object>();
		rs.put("login",login);//当前登录账号
		String headImg="";
		if(login!=null&&login.getLoginType()==2){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
			headImg  = userMsg.getHeadImg();
		}
		rs.put("headImg",headImg);
		rs.put("code",1);
		return rs;
	}
}
