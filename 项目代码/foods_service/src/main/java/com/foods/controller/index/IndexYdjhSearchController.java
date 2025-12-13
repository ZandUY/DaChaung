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
@RequestMapping("index/ydjh_search")
public class IndexYdjhSearchController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YdjhMsgMapper ydjhMsgMapper;
	@Autowired
	BmifwMsgMapper bmifwMsgMapper;
	@Autowired
	YdxhfwMsgMapper ydxhfwMsgMapper;
	//运动计划
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		BmifwMsgExample bmifwMsgE = new BmifwMsgExample();
		rs.put("tableBmifwMsgList",bmifwMsgMapper.selectByExample(bmifwMsgE));
		YdxhfwMsgExample ydxhfwMsgE = new YdxhfwMsgExample();
		rs.put("tableYdxhfwMsgList",ydxhfwMsgMapper.selectByExample(ydxhfwMsgE));
		rs.put("code",1);
		return rs;
	}
	//获取运动计划列表数据
	@RequestMapping("queryYdjhMsgList")
	@ResponseBody
	public Object queryYdjhMsgList(HttpServletRequest request,Integer page,String jhName,Integer bmifw,Integer ydxhfw){
		YdjhMsgExample qe = new YdjhMsgExample();
		YdjhMsgExample.Criteria qc = qe.createCriteria();
		if(jhName!=null&&jhName.trim().equals("")==false){
			qc.andJhNameLike("%"+jhName+"%");//模糊查询
		}
		if(bmifw!=null){
			qc.andBmifwEqualTo(bmifw);
		}
		if(ydxhfw!=null){
			qc.andYdxhfwEqualTo(ydxhfw);
		}
		qe.setOrderByClause("id desc");
		int pageSize=10;
		int count = (int) ydjhMsgMapper.countByExample(qe);
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
		List<YdjhMsg> ql=ydjhMsgMapper.selectByExample(qe);
		List<Map<String,Object>> qlList = new ArrayList<Map<String,Object>>();
		for(YdjhMsg tmp:ql){
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释BMI范围
			BmifwMsg bmifwT = bmifwMsgMapper.selectByPrimaryKey(tmp.getBmifw());
			if(bmifwT==null){
				bmifwT = new BmifwMsg();
			}
			amap.put("bmifw",bmifwT.getFwName());
			//解释运动消耗范围
			YdxhfwMsg ydxhfwT = ydxhfwMsgMapper.selectByPrimaryKey(tmp.getYdxhfw());
			if(ydxhfwT==null){
				ydxhfwT = new YdxhfwMsg();
			}
			amap.put("ydxhfw",ydxhfwT.getFwName());
			amap.put("model",tmp);
			qlList.add(amap);
		}
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("count",count);
		rs.put("pageSize",pageSize);
		rs.put("totalPage",totalPage);
		rs.put("list",qlList);
		return rs;
	}
}
