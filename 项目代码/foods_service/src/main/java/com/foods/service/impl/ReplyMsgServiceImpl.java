package com.foods.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foods.dao.*;
import com.foods.model.*;
import com.foods.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.foods.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.foods.service.*;
import com.foods.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.io.IOException;
@Service
public class ReplyMsgServiceImpl implements ReplyMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	DisMsgMapper disMsgMapper;
	@Autowired
	ReplyMsgMapper replyMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	*根据参数查询回复列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String replyTime1,String replyTime2,ReplyMsg queryModel,Integer pageSize,LoginModel login) {
		ReplyMsgExample se = new ReplyMsgExample();
		ReplyMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getReplyContent()!=null&&queryModel.getReplyContent().equals("")==false){
			sc.andReplyContentLike("%"+queryModel.getReplyContent()+"%");//模糊查询
		}
		if(replyTime1!=null&&replyTime1.equals("")==false){
			sc.andReplyTimeGreaterThanOrEqualTo(replyTime1);
		}
		if(replyTime2!=null&&replyTime2.equals("")==false){
			sc.andReplyTimeLessThanOrEqualTo(replyTime2);
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)replyMsgMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询回复列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String replyTime1,String replyTime2,ReplyMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		ReplyMsgExample se = new ReplyMsgExample();
		ReplyMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getReplyContent()!=null&&queryModel.getReplyContent().equals("")==false){
			sc.andReplyContentLike("%"+queryModel.getReplyContent()+"%");//模糊查询
		}
		if(replyTime1!=null&&replyTime1.equals("")==false){
			sc.andReplyTimeGreaterThanOrEqualTo(replyTime1);
		}
		if(replyTime2!=null&&replyTime2.equals("")==false){
			sc.andReplyTimeLessThanOrEqualTo(replyTime2);
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<ReplyMsg> list = replyMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(ReplyMsg model:list){
			list2.add(getReplyMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装回复为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getReplyMsgModel(ReplyMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("replyMsg",model);
		if(model.getDisId()!=null){
			DisMsg disMsg = disMsgMapper.selectByPrimaryKey(model.getDisId());//评论ID为外接字段，需要关联评论来解释该字段
			map.put("disMsg",disMsg);
			if(disMsg!=null){
				map.put("disIdStr",disMsg.getDisContent());
			}
		}
		if(model.getUserId()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUserId());//用户ID为外接字段，需要关联用户来解释该字段
			map.put("userMsg",userMsg);
			if(userMsg!=null){
				map.put("userIdStr",userMsg.getLoginName());
				map.put("userIdImg",userMsg.getHeadImg());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		replyMsgMapper.deleteByPrimaryKey(id);
	}
}
