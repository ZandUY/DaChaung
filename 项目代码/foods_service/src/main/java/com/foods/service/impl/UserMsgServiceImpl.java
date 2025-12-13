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
public class UserMsgServiceImpl implements UserMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	修改
	*/
	@Override
	public String update(UserMsg model,LoginModel login){
		UserMsg preModel = userMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getName()==null||model.getName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelphone()==null||model.getCelphone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelphone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelphone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getEmail()==null||model.getEmail().equals("")){
			return "邮箱为必填属性";
		}
		if(model.getEmail()!=null){
		Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(model.getEmail());
			if( m.matches()==false){
				return "请输入正确的邮箱";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getSg()==null){
			return "身高为必填属性";
		}
		if(model.getWeight()==null){
			return "体重为必填属性";
		}
		if(model.getAge()==null||model.getAge().equals("")){
			return "年龄为必填属性";
		}
		if(model.getHeadImg()==null||model.getHeadImg().equals("")){
			return "头像为必填属性";
		}
		if(model.getHeadImg()!=null){
			String [] fileSplit = model.getHeadImg().split(";");
			if(fileSplit.length>1){
				return "头像的图片数量不能大于1";
			}
		}
		preModel.setName(model.getName());
		preModel.setCelphone(model.getCelphone());
		preModel.setEmail(model.getEmail());
		preModel.setSex(model.getSex());
		preModel.setSg(model.getSg());
		preModel.setWeight(model.getWeight());
		preModel.setAge(model.getAge());
		preModel.setHeadImg(model.getHeadImg());
		userMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询用户列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(UserMsg queryModel,Integer pageSize,LoginModel login) {
		UserMsgExample se = new UserMsgExample();
		UserMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getName()!=null&&queryModel.getName().equals("")==false){
			sc.andNameLike("%"+queryModel.getName()+"%");//模糊查询
		}
		if(queryModel.getSex()!=null){
			sc.andSexEqualTo(queryModel.getSex());//查询性别等于指定值
		}
		if(login.getLoginType()==2){
			sc.andIdEqualTo(login.getId());//查询权限限制
		}
		int count = (int)userMsgMapper.countByExample(se);
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
	*根据参数查询用户列表数据
	*/
	@Override
	public Map<String,Object> getDataList(UserMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		UserMsgExample se = new UserMsgExample();
		UserMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getName()!=null&&queryModel.getName().equals("")==false){
			sc.andNameLike("%"+queryModel.getName()+"%");//模糊查询
		}
		if(queryModel.getSex()!=null){
			sc.andSexEqualTo(queryModel.getSex());//查询性别等于指定值
		}
		if(login.getLoginType()==2){
			sc.andIdEqualTo(login.getId());//查询权限限制
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<UserMsg> list = userMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(UserMsg model:list){
			list2.add(getUserMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装用户为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getUserMsgModel(UserMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userMsg",model);
		map.put("sexStr",DataListUtils.getSexNameById(model.getSex()+""));//解释性别字段
		List<String> headImgList = new ArrayList<String>();
		if(model.getHeadImg()!=null){
			String [] headImgSplit = model.getHeadImg().split(";");
			for(String tmpstr:headImgSplit ){
				if(tmpstr.equals("")==false){
					headImgList.add(tmpstr);
				}
			}
		}
		map.put("headImgList",headImgList);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		userMsgMapper.deleteByPrimaryKey(id);
	}
}
