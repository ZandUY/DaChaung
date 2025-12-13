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
public class PostMsgServiceImpl implements PostMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	PostMsgMapper postMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(PostMsg model,LoginModel login){
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getSubtitle()==null||model.getSubtitle().equals("")){
			return "副标题为必填属性";
		}
		if(model.getPostDetail()==null||model.getPostDetail().equals("")){
			return "帖子详情为必填属性";
		}
		model.setUserId(login.getId());//登录id
		model.setFbTime(sdf1.format(new Date()));//当前时间格式
		postMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(PostMsg model,LoginModel login){
		PostMsg preModel = postMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getSubtitle()==null||model.getSubtitle().equals("")){
			return "副标题为必填属性";
		}
		if(model.getPostDetail()==null||model.getPostDetail().equals("")){
			return "帖子详情为必填属性";
		}
		preModel.setTitle(model.getTitle());
		preModel.setSubtitle(model.getSubtitle());
		preModel.setPostDetail(model.getPostDetail());
		postMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询帖子列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(PostMsg queryModel,Integer pageSize,LoginModel login) {
		PostMsgExample se = new PostMsgExample();
		PostMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getSubtitle()!=null&&queryModel.getSubtitle().equals("")==false){
			sc.andSubtitleLike("%"+queryModel.getSubtitle()+"%");//模糊查询
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)postMsgMapper.countByExample(se);
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
	*根据参数查询帖子列表数据
	*/
	@Override
	public Map<String,Object> getDataList(PostMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		PostMsgExample se = new PostMsgExample();
		PostMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getSubtitle()!=null&&queryModel.getSubtitle().equals("")==false){
			sc.andSubtitleLike("%"+queryModel.getSubtitle()+"%");//模糊查询
		}
		if(login.getLoginType()==2){
			sc.andUserIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<PostMsg> list = postMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(PostMsg model:list){
			list2.add(getPostMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装帖子为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getPostMsgModel(PostMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("postMsg",model);
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
		postMsgMapper.deleteByPrimaryKey(id);
	}
}
