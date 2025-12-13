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
public class DisMsgServiceImpl implements DisMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	DisMsgMapper disMsgMapper;
	@Autowired
	PostMsgMapper postMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	*根据参数查询评论列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String disTime1,String disTime2,DisMsg queryModel,Integer pageSize,LoginModel login) {
		DisMsgExample se = new DisMsgExample();
		DisMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDisContent()!=null&&queryModel.getDisContent().equals("")==false){
			sc.andDisContentLike("%"+queryModel.getDisContent()+"%");//模糊查询
		}
		if(disTime1!=null&&disTime1.equals("")==false){
			sc.andDisTimeGreaterThanOrEqualTo(disTime1);
		}
		if(disTime2!=null&&disTime2.equals("")==false){
			sc.andDisTimeLessThanOrEqualTo(disTime2);
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)disMsgMapper.countByExample(se);
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
	*根据参数查询评论列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String disTime1,String disTime2,DisMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		DisMsgExample se = new DisMsgExample();
		DisMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDisContent()!=null&&queryModel.getDisContent().equals("")==false){
			sc.andDisContentLike("%"+queryModel.getDisContent()+"%");//模糊查询
		}
		if(disTime1!=null&&disTime1.equals("")==false){
			sc.andDisTimeGreaterThanOrEqualTo(disTime1);
		}
		if(disTime2!=null&&disTime2.equals("")==false){
			sc.andDisTimeLessThanOrEqualTo(disTime2);
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<DisMsg> list = disMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(DisMsg model:list){
			list2.add(getDisMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装评论为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getDisMsgModel(DisMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("disMsg",model);
		if(model.getPostId()!=null){
			PostMsg postMsg = postMsgMapper.selectByPrimaryKey(model.getPostId());//帖子ID为外接字段，需要关联帖子来解释该字段
			map.put("postMsg",postMsg);
			if(postMsg!=null){
				map.put("postIdStr",postMsg.getTitle());
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
		disMsgMapper.deleteByPrimaryKey(id);
	}
}
