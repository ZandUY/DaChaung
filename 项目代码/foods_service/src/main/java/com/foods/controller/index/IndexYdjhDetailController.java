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
@RequestMapping("index/ydjh_detail")
public class IndexYdjhDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YdjhMsgMapper ydjhMsgMapper;
	@Autowired
	YdCollectMsgMapper ydCollectMsgMapper;
	@Autowired
	BmifwMsgMapper bmifwMsgMapper;
	@Autowired
	YdxhfwMsgMapper ydxhfwMsgMapper;
	//运动计划详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		YdjhMsg ydjhMsg = ydjhMsgMapper.selectByPrimaryKey(id);//根据主键查询运动计划
		if(ydjhMsg==null){
			ydjhMsg = new YdjhMsg();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		ydjhMsg.setFbTime(CommonUtils.coverToShowTime(ydjhMsg.getFbTime(),sdf1));
		dataDetail.put("model",ydjhMsg);
		//将多张图片以list形式返回给前端
		List<String> fmImgList = new ArrayList<String>();
		if(ydjhMsg.getFmImg()!=null&&ydjhMsg.getFmImg().trim().equals("")==false){
			String [] fmImgSplit = ydjhMsg.getFmImg().split(";");
			for(String fmImgStr:fmImgSplit){
				if(fmImgStr.trim().equals("")==false){
					fmImgList.add(fmImgStr);
				}
			}
		}
		dataDetail.put("fmImgList",fmImgList);
		//解释BMI范围
		BmifwMsg bmifwT = bmifwMsgMapper.selectByPrimaryKey(ydjhMsg.getBmifw());
		if(bmifwT==null){
			bmifwT = new BmifwMsg();
		}
		dataDetail.put("bmifwT",bmifwT);
		//解释运动消耗范围
		YdxhfwMsg ydxhfwT = ydxhfwMsgMapper.selectByPrimaryKey(ydjhMsg.getYdxhfw());
		if(ydxhfwT==null){
			ydxhfwT = new YdxhfwMsg();
		}
		dataDetail.put("ydxhfwT",ydxhfwT);
		rs.put("ydjhMsgDetail",dataDetail);
		Integer isCollect=0;//是否有运动收藏
		if(login!=null&&login.getLoginType()==2){//判断是否已登录
			YdCollectMsgExample ydCollectMsgE = new  YdCollectMsgExample();
			YdCollectMsgExample.Criteria ydCollectMsgC =ydCollectMsgE.createCriteria();
			ydCollectMsgC.andUserIdEqualTo(login.getId());//yd_collect_msg.user_id=当前登录id
			ydCollectMsgC.andYdjhEqualTo(ydjhMsg.getId());
			int ydCollectMsgCount = (int)ydCollectMsgMapper.countByExample(ydCollectMsgE);//查询是否有运动收藏
			if(ydCollectMsgCount>0){
				isCollect=1;
			}
		}
		rs.put("isCollect", isCollect);
		rs.put("code",1);
		return rs;
	}
	//提交运动收藏接口
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
		YdCollectMsgExample ydCollectMsgE = new  YdCollectMsgExample();
		YdCollectMsgExample.Criteria ydCollectMsgC =ydCollectMsgE.createCriteria();
		ydCollectMsgC.andUserIdEqualTo(login.getId());
		ydCollectMsgC.andYdjhEqualTo(id);
		int ydCollectMsgCount = (int)ydCollectMsgMapper.countByExample(ydCollectMsgE);
		if(ydCollectMsgCount>0){//已运动收藏，要取消运动收藏
			ydCollectMsgMapper.deleteByExample(ydCollectMsgE);
			rs.put("code",1);
			rs.put("msg","取消运动收藏成功");
			return rs;
		}else{
			//没运动收藏，需要新建运动收藏并插入数据库
			YdCollectMsg ydCollectMsg = new YdCollectMsg();
			ydCollectMsg.setYdjh(id);
			ydCollectMsg.setUserId(login.getId());//登录id
			ydCollectMsg.setCollectTime(sdf1.format(new Date()));//当前时间格式
			ydCollectMsgMapper.insertSelective(ydCollectMsg );
			rs.put("code",1);
			rs.put("msg","运动收藏成功");
			return rs;
		}
	}
}
