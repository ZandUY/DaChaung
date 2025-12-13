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
@RequestMapping("index/post_search")
public class IndexPostSearchController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	PostMsgMapper postMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	//帖子搜索
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("code",1);
		return rs;
	}
	//获取帖子列表数据
	@RequestMapping("queryPostMsgList")
	@ResponseBody
	public Object queryPostMsgList(HttpServletRequest request,Integer page,String title){
		PostMsgExample qe = new PostMsgExample();
		PostMsgExample.Criteria qc = qe.createCriteria();
		if(title!=null&&title.trim().equals("")==false){
			qc.andTitleLike("%"+title+"%");//模糊查询
		}
		qe.setOrderByClause("id desc");
		int pageSize=10;
		int count = (int) postMsgMapper.countByExample(qe);
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
		List<PostMsg> ql=postMsgMapper.selectByExample(qe);
		List<Map<String,Object>> qlList = new ArrayList<Map<String,Object>>();
		for(PostMsg tmp:ql){
			tmp.setFbTime(CommonUtils.coverToShowTime(tmp.getFbTime(),sdf1));
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释用户ID
			UserMsg userIdT = userMsgMapper.selectByPrimaryKey(tmp.getUserId());
			if(userIdT==null){
				userIdT = new UserMsg();
			}
			amap.put("userId",userIdT.getLoginName());
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
