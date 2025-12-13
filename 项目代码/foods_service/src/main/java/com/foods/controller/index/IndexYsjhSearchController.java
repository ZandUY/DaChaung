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
@RequestMapping("index/ysjh_search")
public class IndexYsjhSearchController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YsjhMsgMapper ysjhMsgMapper;
	@Autowired
	BmifwMsgMapper bmifwMsgMapper;
	@Autowired
	YnumFwMsgMapper ynumFwMsgMapper;
	//饮食计划
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		BmifwMsgExample bmifwMsgE = new BmifwMsgExample();
		rs.put("tableBmifwMsgList",bmifwMsgMapper.selectByExample(bmifwMsgE));
		YnumFwMsgExample ynumFwMsgE = new YnumFwMsgExample();
		rs.put("tableYnumFwMsgList",ynumFwMsgMapper.selectByExample(ynumFwMsgE));
		rs.put("code",1);
		return rs;
	}
	//获取饮食计划列表数据
	@RequestMapping("queryYsjhMsgList")
	@ResponseBody
	public Object queryYsjhMsgList(HttpServletRequest request,Integer page,String jhName,Integer bmifw,Integer ynumFw){
		YsjhMsgExample qe = new YsjhMsgExample();
		YsjhMsgExample.Criteria qc = qe.createCriteria();
		if(jhName!=null&&jhName.trim().equals("")==false){
			qc.andJhNameLike("%"+jhName+"%");//模糊查询
		}
		if(bmifw!=null){
			qc.andBmifwEqualTo(bmifw);
		}
		if(ynumFw!=null){
			qc.andYnumFwEqualTo(ynumFw);
		}
		qe.setOrderByClause("id desc");
		int pageSize=10;
		int count = (int) ysjhMsgMapper.countByExample(qe);
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
		List<YsjhMsg> ql=ysjhMsgMapper.selectByExample(qe);
		List<Map<String,Object>> qlList = new ArrayList<Map<String,Object>>();
		for(YsjhMsg tmp:ql){
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释BMI范围
			BmifwMsg bmifwT = bmifwMsgMapper.selectByPrimaryKey(tmp.getBmifw());
			if(bmifwT==null){
				bmifwT = new BmifwMsg();
			}
			amap.put("bmifw",bmifwT.getFwName());
			//解释饮食热量范围
			YnumFwMsg ynumFwT = ynumFwMsgMapper.selectByPrimaryKey(tmp.getYnumFw());
			if(ynumFwT==null){
				ynumFwT = new YnumFwMsg();
			}
			amap.put("ynumFw",ynumFwT.getFwName());
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
