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
@RequestMapping("index/post_detail")
public class IndexPostDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	DisMsgMapper disMsgMapper;
	@Autowired
	PostMsgMapper postMsgMapper;
	@Autowired
	ReplyMsgMapper replyMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	//帖子详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		PostMsg postMsg = postMsgMapper.selectByPrimaryKey(id);//根据主键查询帖子
		if(postMsg==null){
			postMsg = new PostMsg();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		postMsg.setFbTime(CommonUtils.coverToShowTime(postMsg.getFbTime(),sdf1));
		dataDetail.put("model",postMsg);
		//解释用户ID
		UserMsg userIdT = userMsgMapper.selectByPrimaryKey(postMsg.getUserId());
		if(userIdT==null){
			userIdT = new UserMsg();
		}
		dataDetail.put("userIdT",userIdT);
		rs.put("postMsgDetail",dataDetail);
		rs.put("code",1);
		return rs;
	}
	//提交回复接口
	@RequestMapping("submitReply")
	@ResponseBody
	public Object submitReply(HttpServletRequest request,Integer id,String content){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if(content==null||content.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入回复内容");
			return rs;
		}
		ReplyMsg replyMsg = new ReplyMsg();
		replyMsg.setReplyContent(content);
		replyMsg.setDisId(id);
		replyMsg.setUserId(login.getId());//登录id
		replyMsg.setReplyTime(sdf1.format(new Date()));//当前时间格式
		replyMsgMapper.insertSelective(replyMsg);//插入数据库
		rs.put("code",1);
		rs.put("msg","回复成功");
		return rs;
	}
	//分页查询评论列表接口
	@RequestMapping("getDisMsg")
	@ResponseBody
	public Object getDisMsg(HttpServletRequest request,Integer page,Integer id){
		Map<String,Object> rs  = new HashMap<String,Object>();
		Integer pageSize=8;
		DisMsgExample te = new DisMsgExample();
		DisMsgExample.Criteria tc = te.createCriteria();
		tc.andPostIdEqualTo(id);
		te.setOrderByClause("id desc");
		int count = (int)disMsgMapper.countByExample(te);
		int totalPage = 0;
		if ((page != null) && (pageSize != null)) { //分页
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			te.setPageRows(pageSize);//设置每页数量
			te.setStartRow((page - 1) * pageSize);//设置当前第几页
		}
		List<DisMsg> tl = disMsgMapper.selectByExample(te);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(DisMsg t:tl){
			Map<String,Object> map = new HashMap<String,Object>();
			t.setDisTime(CommonUtils.coverToShowTime(t.getDisTime(),sdf1));
			map.put("model",t);
			UserMsg userIdT2=userMsgMapper.selectByPrimaryKey(t.getUserId());
			map.put("userIdT",userIdT2);
			//查询回复列表
			ReplyMsgExample replyMsgE = new ReplyMsgExample();
			replyMsgE.setOrderByClause("id desc");
			ReplyMsgExample.Criteria replyMsgC = replyMsgE.createCriteria();
			replyMsgC.andDisIdEqualTo(t.getId());
			List<ReplyMsg> replyList1 = replyMsgMapper.selectByExample(replyMsgE);
			List<Map<String,Object>> replyList = new ArrayList<Map<String,Object>>();
			for(ReplyMsg replyMsg:replyList1){
				replyMsg.setReplyTime(CommonUtils.coverToShowTime(replyMsg.getReplyTime(),sdf1));
				Map<String,Object> replyMsgMap = new HashMap<String,Object>();
				replyMsgMap.put("model",replyMsg);
				//根据用户ID查询用户
				UserMsg userIdT1=userMsgMapper.selectByPrimaryKey(replyMsg.getUserId());
				if(userIdT1==null){
					userIdT1= new UserMsg();
				}
				replyMsgMap.put("userIdT",userIdT1);
				replyList.add(replyMsgMap);
			}
			map.put("replyList",replyList);
			list.add(map);
		}
		rs.put("list",list);
		rs.put("count",count);
		rs.put("totalPage",totalPage);
		rs.put("pageSize",pageSize);
		return rs;
	}
	//提交评论接口
	@RequestMapping("submitDisMsg")
	@ResponseBody
	public Object submitDisMsg(HttpServletRequest request,Integer id,String cdisContent){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if(cdisContent==null||cdisContent.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入评论内容");
			return rs;
		}
		DisMsg disMsg = new DisMsg();
		disMsg.setDisContent(cdisContent);
		disMsg.setPostId(id);//帖子id
		disMsg.setUserId(login.getId());//登录id
		disMsg.setDisTime(sdf1.format(new Date()));//当前时间格式
		disMsgMapper.insertSelective(disMsg);
		rs.put("code",1);
		rs.put("msg","评论成功");
		return rs;
	}
}
