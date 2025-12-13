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
@RequestMapping("index/ysjh_detail")
public class IndexYsjhDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YsjhMsgMapper ysjhMsgMapper;
	@Autowired
	YsCollectMsgMapper ysCollectMsgMapper;
	@Autowired
	BmifwMsgMapper bmifwMsgMapper;
	@Autowired
	YnumFwMsgMapper ynumFwMsgMapper;
	//饮食计划详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		YsjhMsg ysjhMsg = ysjhMsgMapper.selectByPrimaryKey(id);//根据主键查询饮食计划
		if(ysjhMsg==null){
			ysjhMsg = new YsjhMsg();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		ysjhMsg.setFbTime(CommonUtils.coverToShowTime(ysjhMsg.getFbTime(),sdf1));
		dataDetail.put("model",ysjhMsg);
		//将多张图片以list形式返回给前端
		List<String> fmImgList = new ArrayList<String>();
		if(ysjhMsg.getFmImg()!=null&&ysjhMsg.getFmImg().trim().equals("")==false){
			String [] fmImgSplit = ysjhMsg.getFmImg().split(";");
			for(String fmImgStr:fmImgSplit){
				if(fmImgStr.trim().equals("")==false){
					fmImgList.add(fmImgStr);
				}
			}
		}
		dataDetail.put("fmImgList",fmImgList);
		//解释BMI范围
		BmifwMsg bmifwT = bmifwMsgMapper.selectByPrimaryKey(ysjhMsg.getBmifw());
		if(bmifwT==null){
			bmifwT = new BmifwMsg();
		}
		dataDetail.put("bmifwT",bmifwT);
		//解释饮食热量范围
		YnumFwMsg ynumFwT = ynumFwMsgMapper.selectByPrimaryKey(ysjhMsg.getYnumFw());
		if(ynumFwT==null){
			ynumFwT = new YnumFwMsg();
		}
		dataDetail.put("ynumFwT",ynumFwT);
		rs.put("ysjhMsgDetail",dataDetail);
		Integer isCollect=0;//是否有饮食收藏
		if(login!=null&&login.getLoginType()==2){//判断是否已登录
			YsCollectMsgExample ysCollectMsgE = new  YsCollectMsgExample();
			YsCollectMsgExample.Criteria ysCollectMsgC =ysCollectMsgE.createCriteria();
			ysCollectMsgC.andUserIdEqualTo(login.getId());//ys_collect_msg.user_id=当前登录id
			ysCollectMsgC.andYsjhEqualTo(ysjhMsg.getId());
			int ysCollectMsgCount = (int)ysCollectMsgMapper.countByExample(ysCollectMsgE);//查询是否有饮食收藏
			if(ysCollectMsgCount>0){
				isCollect=1;
			}
		}
		rs.put("isCollect", isCollect);
		rs.put("code",1);
		return rs;
	}
	//提交饮食收藏接口
	@RequestMapping("submitCollect")
	@ResponseBody
	public Object submitCollect(HttpServletRequest request,Integer id){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//当前登录人信息
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		YsCollectMsgExample ysCollectMsgE = new  YsCollectMsgExample();
		YsCollectMsgExample.Criteria ysCollectMsgC =ysCollectMsgE.createCriteria();
		ysCollectMsgC.andUserIdEqualTo(login.getId());
		ysCollectMsgC.andYsjhEqualTo(id);
		int ysCollectMsgCount = (int)ysCollectMsgMapper.countByExample(ysCollectMsgE);
		if(ysCollectMsgCount>0){//已饮食收藏，要取消饮食收藏
			ysCollectMsgMapper.deleteByExample(ysCollectMsgE);
			rs.put("code",1);
			rs.put("msg","取消饮食收藏成功");
			return rs;
		}else{
			//没饮食收藏，需要新建饮食收藏并插入数据库
			YsCollectMsg ysCollectMsg = new YsCollectMsg();
			ysCollectMsg.setYsjh(id);
			ysCollectMsg.setUserId(login.getId());//登录id
			ysCollectMsg.setCollectTime(sdf1.format(new Date()));//当前时间格式
			ysCollectMsgMapper.insertSelective(ysCollectMsg );
			rs.put("code",1);
			rs.put("msg","饮食收藏成功");
			return rs;
		}
	}
}
