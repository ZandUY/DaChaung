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
@RequestMapping("index/yyxcs_detail")
public class IndexYyxcsDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YyxcsMsgMapper yyxcsMsgMapper;
	//营养小常识详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		YyxcsMsg yyxcsMsg = yyxcsMsgMapper.selectByPrimaryKey(id);//根据主键查询营养小常识
		if(yyxcsMsg==null){
			yyxcsMsg = new YyxcsMsg();
		}
		yyxcsMsg.setFbTime(CommonUtils.coverToShowTime(yyxcsMsg.getFbTime(),sdf1));
		rs.put("yyxcsMsgDetail",yyxcsMsg);
		rs.put("code",1);
		return rs;
	}
}
