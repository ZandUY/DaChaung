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
@RequestMapping("index/index")
public class IndexIndexController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	YdjhMsgMapper ydjhMsgMapper;
	@Autowired
	YsjhMsgMapper ysjhMsgMapper;
	@Autowired
	YdCollectMsgMapper ydCollectMsgMapper;
	@Autowired
	YsCollectMsgMapper ysCollectMsgMapper;
	@Autowired
	PostMsgMapper postMsgMapper;
	@Autowired
	YyxcsMsgMapper yyxcsMsgMapper;
	@Autowired
	BannerMsgMapper bannerMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	BmifwMsgMapper bmifwMsgMapper;
	@Autowired
	YdxhfwMsgMapper ydxhfwMsgMapper;
	@Autowired
	YnumFwMsgMapper ynumFwMsgMapper;
	//首页
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		BannerMsgExample be = new BannerMsgExample();
		BannerMsgExample.Criteria bc = be.createCriteria();
		be.setOrderByClause("id desc");
		int blSize=10;
		be.setPageRows(blSize);//每页数量
		be.setStartRow(0);//第一页
		List<BannerMsg> bl=bannerMsgMapper.selectByExample(be);
		rs.put("bl",bl);
		YsjhMsgExample ye = new YsjhMsgExample();
		YsjhMsgExample.Criteria yc = ye.createCriteria();
		ye.setOrderByClause("id desc");
		int ylSize=10;
		ye.setPageRows(ylSize);//每页数量
		ye.setStartRow(0);//第一页
		List<Map<String,Object>> ylList = new ArrayList<Map<String,Object>>();
		if(login==null||login.getLoginType()!=2) {
		}else{
			List<Integer> yids = new ArrayList<Integer>();
			YsjhMsgExample ye2 = new YsjhMsgExample();
			YsjhMsgExample.Criteria yc2 = ye2.createCriteria();
			List<YsjhMsg> yl2 = ysjhMsgMapper.selectByExample(ye2);//查询所有的饮食计划
			for(YsjhMsg tmp:yl2){
				yids.add(tmp.getId());
			}
			ReferUtils cf = new ReferUtils();//推荐算法工具类
			List<Map<String,Object>> ulist = new ArrayList<Map<String,Object>>();
			UserMsgExample use = new UserMsgExample();
			UserMsgExample.Criteria usc = use.createCriteria();
			List<UserMsg> usl = userMsgMapper.selectByExample(use);//查询所有的用户
			for(UserMsg us:usl){
				YsCollectMsgExample ye3 = new YsCollectMsgExample();
				YsCollectMsgExample.Criteria yc3 = ye3.createCriteria();
				yc3.andUserIdEqualTo(us.getId());
				List<YsCollectMsg> yl = ysCollectMsgMapper.selectByExample(ye3);//查询该用户下的所有饮食收藏
				List<Map<String,String>> uscores  = new ArrayList<Map<String,String>>();
				for(YsCollectMsg y:yl){
					uscores.add(cf.getScoreMap(y.getYsjh(),1.0));//获取该用户对饮食计划的推荐集合
				}
				ulist.add(cf.initAScore(us.getId(),uscores,yids));//将所有用户的推荐信息都封装一起，然后给推荐工具进行计算
			}
			cf.castToRatting(ulist,yids);//传输封装后的数据到对象里
			List<Map<String,String>> rs3 =  cf.getReferList(login.getId(),10);//得到推荐结果
			for(Map<String,String> map:rs3) {
				YsjhMsg ysjhMsg =ysjhMsgMapper.selectByPrimaryKey(Integer.parseInt(map.get("proId")));
				Map<String,Object> amap = new HashMap<String,Object>();
				String score = map.get("score").toString();//推荐分数
				if(score.startsWith(".")){
					score = "0"+score;
				}
				ysjhMsg.setJhName("<span style=\"color:red\">【"+score+"分】</span>"+ysjhMsg.getJhName());
				//解释BMI范围
				BmifwMsg bmifwT = bmifwMsgMapper.selectByPrimaryKey(ysjhMsg.getBmifw());
				if(bmifwT==null){
					bmifwT = new BmifwMsg();
				}
				amap.put("bmifw",bmifwT.getFwName());
				//解释饮食热量范围
				YnumFwMsg ynumFwT = ynumFwMsgMapper.selectByPrimaryKey(ysjhMsg.getYnumFw());
				if(ynumFwT==null){
					ynumFwT = new YnumFwMsg();
				}
				amap.put("ynumFw",ynumFwT.getFwName());
				amap.put("model",ysjhMsg);
				ylList.add(amap);
			}
		}
		rs.put("yl",ylList);
		YsjhMsgExample ye1 = new YsjhMsgExample();
		YsjhMsgExample.Criteria yc1 = ye1.createCriteria();
		ye1.setOrderByClause("id desc");
		int yl1Size=10;
		ye1.setPageRows(yl1Size);//每页数量
		ye1.setStartRow(0);//第一页
		List<YsjhMsg> yl1=ysjhMsgMapper.selectByExample(ye1);
		List<Map<String,Object>> yl1List = new ArrayList<Map<String,Object>>();
		for(YsjhMsg tmp:yl1){
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释BMI范围
			BmifwMsg bmifwT1 = bmifwMsgMapper.selectByPrimaryKey(tmp.getBmifw());
			if(bmifwT1==null){
				bmifwT1 = new BmifwMsg();
			}
			amap.put("bmifw",bmifwT1.getFwName());
			//解释饮食热量范围
			YnumFwMsg ynumFwT1 = ynumFwMsgMapper.selectByPrimaryKey(tmp.getYnumFw());
			if(ynumFwT1==null){
				ynumFwT1 = new YnumFwMsg();
			}
			amap.put("ynumFw",ynumFwT1.getFwName());
			amap.put("model",tmp);
			yl1List.add(amap);
		}
		rs.put("yl1",yl1List);
		YdjhMsgExample ye2 = new YdjhMsgExample();
		YdjhMsgExample.Criteria yc2 = ye2.createCriteria();
		ye2.setOrderByClause("id desc");
		int yl2Size=10;
		ye2.setPageRows(yl2Size);//每页数量
		ye2.setStartRow(0);//第一页
		List<Map<String,Object>> yl2List = new ArrayList<Map<String,Object>>();
		if(login==null||login.getLoginType()!=2) {
		}else{
			List<Integer> yids2 = new ArrayList<Integer>();
			YdjhMsgExample ye22 = new YdjhMsgExample();
			YdjhMsgExample.Criteria yc22 = ye22.createCriteria();
			List<YdjhMsg> yl22 = ydjhMsgMapper.selectByExample(ye22);//查询所有的运动计划
			for(YdjhMsg tmp:yl22){
				yids2.add(tmp.getId());
			}
			ReferUtils cf = new ReferUtils();//推荐算法工具类
			List<Map<String,Object>> ulist = new ArrayList<Map<String,Object>>();
			UserMsgExample use = new UserMsgExample();
			UserMsgExample.Criteria usc = use.createCriteria();
			List<UserMsg> usl = userMsgMapper.selectByExample(use);//查询所有的用户
			for(UserMsg us:usl){
				YdCollectMsgExample ye3 = new YdCollectMsgExample();
				YdCollectMsgExample.Criteria yc3 = ye3.createCriteria();
				yc3.andUserIdEqualTo(us.getId());
				List<YdCollectMsg> yl3 = ydCollectMsgMapper.selectByExample(ye3);//查询该用户下的所有运动收藏
				List<Map<String,String>> uscores  = new ArrayList<Map<String,String>>();
				for(YdCollectMsg y:yl3){
					uscores.add(cf.getScoreMap(y.getYdjh(),1.0));//获取该用户对运动计划的推荐集合
				}
				ulist.add(cf.initAScore(us.getId(),uscores,yids2));//将所有用户的推荐信息都封装一起，然后给推荐工具进行计算
			}
			cf.castToRatting(ulist,yids2);//传输封装后的数据到对象里
			List<Map<String,String>> rs3 =  cf.getReferList(login.getId(),10);//得到推荐结果
			for(Map<String,String> map:rs3) {
				YdjhMsg ydjhMsg =ydjhMsgMapper.selectByPrimaryKey(Integer.parseInt(map.get("proId")));
				Map<String,Object> amap = new HashMap<String,Object>();
				String score = map.get("score").toString();//推荐分数
				if(score.startsWith(".")){
					score = "0"+score;
				}
				ydjhMsg.setJhName("<span style=\"color:red\">【"+score+"分】</span>"+ydjhMsg.getJhName());
				//解释BMI范围
				BmifwMsg bmifwT2 = bmifwMsgMapper.selectByPrimaryKey(ydjhMsg.getBmifw());
				if(bmifwT2==null){
					bmifwT2 = new BmifwMsg();
				}
				amap.put("bmifw",bmifwT2.getFwName());
				//解释运动消耗范围
				YdxhfwMsg ydxhfwT = ydxhfwMsgMapper.selectByPrimaryKey(ydjhMsg.getYdxhfw());
				if(ydxhfwT==null){
					ydxhfwT = new YdxhfwMsg();
				}
				amap.put("ydxhfw",ydxhfwT.getFwName());
				amap.put("model",ydjhMsg);
				yl2List.add(amap);
			}
		}
		rs.put("yl2",yl2List);
		YdjhMsgExample ye3 = new YdjhMsgExample();
		YdjhMsgExample.Criteria yc3 = ye3.createCriteria();
		ye3.setOrderByClause("id desc");
		int yl3Size=10;
		ye3.setPageRows(yl3Size);//每页数量
		ye3.setStartRow(0);//第一页
		List<YdjhMsg> yl3=ydjhMsgMapper.selectByExample(ye3);
		List<Map<String,Object>> yl3List = new ArrayList<Map<String,Object>>();
		for(YdjhMsg tmp:yl3){
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释BMI范围
			BmifwMsg bmifwT3 = bmifwMsgMapper.selectByPrimaryKey(tmp.getBmifw());
			if(bmifwT3==null){
				bmifwT3 = new BmifwMsg();
			}
			amap.put("bmifw",bmifwT3.getFwName());
			//解释运动消耗范围
			YdxhfwMsg ydxhfwT1 = ydxhfwMsgMapper.selectByPrimaryKey(tmp.getYdxhfw());
			if(ydxhfwT1==null){
				ydxhfwT1 = new YdxhfwMsg();
			}
			amap.put("ydxhfw",ydxhfwT1.getFwName());
			amap.put("model",tmp);
			yl3List.add(amap);
		}
		rs.put("yl3",yl3List);
		PostMsgExample pe = new PostMsgExample();
		PostMsgExample.Criteria pc = pe.createCriteria();
		pe.setOrderByClause("id desc");
		int plSize=10;
		pe.setPageRows(plSize);//每页数量
		pe.setStartRow(0);//第一页
		List<PostMsg> pl=postMsgMapper.selectByExample(pe);
		List<Map<String,Object>> plList = new ArrayList<Map<String,Object>>();
		for(PostMsg tmp:pl){
			tmp.setFbTime(CommonUtils.coverToShowTime(tmp.getFbTime(),sdf1));
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释用户ID
			UserMsg userIdT = userMsgMapper.selectByPrimaryKey(tmp.getUserId());
			if(userIdT==null){
				userIdT = new UserMsg();
			}
			amap.put("userId",userIdT.getLoginName());
			amap.put("model",tmp);
			plList.add(amap);
		}
		rs.put("pl",plList);
		YyxcsMsgExample ye4 = new YyxcsMsgExample();
		YyxcsMsgExample.Criteria yc4 = ye4.createCriteria();
		ye4.setOrderByClause("id desc");
		int yl4Size=10;
		ye4.setPageRows(yl4Size);//每页数量
		ye4.setStartRow(0);//第一页
		List<YyxcsMsg> yl4=yyxcsMsgMapper.selectByExample(ye4);
		rs.put("yl4",yl4);
		rs.put("code",1);
		return rs;
	}
}
