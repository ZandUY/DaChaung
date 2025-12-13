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
public class XtIntroMsgServiceImpl implements XtIntroMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	XtIntroMsgMapper xtIntroMsgMapper;
	/**
	修改
	*/
	@Override
	public String update(XtIntroMsg model,LoginModel login){
		XtIntroMsg preModel = xtIntroMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getFmImg()==null||model.getFmImg().equals("")){
			return "封面图为必填属性";
		}
		if(model.getFmImg()!=null){
			String [] fileSplit = model.getFmImg().split(";");
			if(fileSplit.length>1){
				return "封面图的图片数量不能大于1";
			}
		}
		if(model.getIntroDetail()==null||model.getIntroDetail().equals("")){
			return "介绍详情为必填属性";
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
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "地址为必填属性";
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
		preModel.setTitle(model.getTitle());
		preModel.setFmImg(model.getFmImg());
		preModel.setIntroDetail(model.getIntroDetail());
		preModel.setCelphone(model.getCelphone());
		preModel.setAddress(model.getAddress());
		preModel.setEmail(model.getEmail());
		xtIntroMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询系统介绍列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(XtIntroMsg queryModel,Integer pageSize,LoginModel login) {
		XtIntroMsgExample se = new XtIntroMsgExample();
		XtIntroMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getCelphone()!=null&&queryModel.getCelphone().equals("")==false){
			sc.andCelphoneLike("%"+queryModel.getCelphone()+"%");//模糊查询
		}
		if(queryModel.getAddress()!=null&&queryModel.getAddress().equals("")==false){
			sc.andAddressLike("%"+queryModel.getAddress()+"%");//模糊查询
		}
		if(queryModel.getEmail()!=null&&queryModel.getEmail().equals("")==false){
			sc.andEmailLike("%"+queryModel.getEmail()+"%");//模糊查询
		}
		int count = (int)xtIntroMsgMapper.countByExample(se);
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
	*根据参数查询系统介绍列表数据
	*/
	@Override
	public Map<String,Object> getDataList(XtIntroMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		XtIntroMsgExample se = new XtIntroMsgExample();
		XtIntroMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getCelphone()!=null&&queryModel.getCelphone().equals("")==false){
			sc.andCelphoneLike("%"+queryModel.getCelphone()+"%");//模糊查询
		}
		if(queryModel.getAddress()!=null&&queryModel.getAddress().equals("")==false){
			sc.andAddressLike("%"+queryModel.getAddress()+"%");//模糊查询
		}
		if(queryModel.getEmail()!=null&&queryModel.getEmail().equals("")==false){
			sc.andEmailLike("%"+queryModel.getEmail()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<XtIntroMsg> list = xtIntroMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(XtIntroMsg model:list){
			list2.add(getXtIntroMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装系统介绍为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getXtIntroMsgModel(XtIntroMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("xtIntroMsg",model);
		List<String> fmImgList = new ArrayList<String>();
		if(model.getFmImg()!=null){
			String [] fmImgSplit = model.getFmImg().split(";");
			for(String tmpstr:fmImgSplit ){
				if(tmpstr.equals("")==false){
					fmImgList.add(tmpstr);
				}
			}
		}
		map.put("fmImgList",fmImgList);
		return map;
	}
}
