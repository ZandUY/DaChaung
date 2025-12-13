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
@RequestMapping("index/yyxcs_search")
public class IndexYyxcsSearchController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YyxcsMsgMapper yyxcsMsgMapper;
	//营养小常识
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("code",1);
		return rs;
	}
	//获取营养小常识列表数据
	@RequestMapping("queryYyxcsMsgList")
	@ResponseBody
	public Object queryYyxcsMsgList(HttpServletRequest request,Integer page,String title){
		YyxcsMsgExample qe = new YyxcsMsgExample();
		YyxcsMsgExample.Criteria qc = qe.createCriteria();
		if(title!=null&&title.trim().equals("")==false){
			qc.andTitleLike("%"+title+"%");//模糊查询
		}
		qe.setOrderByClause("id desc");
		int pageSize=10;
		int count = (int) yyxcsMsgMapper.countByExample(qe);
		int totalPage = 0;
		if (page != null) {
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			qe.setPageRows(pageSize);//每页数量
			qe.setStartRow((page - 1) * pageSize);//第几页
		}
		List<YyxcsMsg> ql=yyxcsMsgMapper.selectByExample(qe);
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("count",count);
		rs.put("pageSize",pageSize);
		rs.put("totalPage",totalPage);
		rs.put("list",ql);
		return rs;
	}
}
