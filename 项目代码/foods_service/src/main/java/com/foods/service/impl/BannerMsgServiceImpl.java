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
public class BannerMsgServiceImpl implements BannerMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	BannerMsgMapper bannerMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(BannerMsg model,LoginModel login){
		if(model.getBanner()==null||model.getBanner().equals("")){
			return "轮播图为必填属性";
		}
		if(model.getBanner()!=null){
			String [] fileSplit = model.getBanner().split(";");
			if(fileSplit.length>1){
				return "轮播图的图片数量不能大于1";
			}
		}
		bannerMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(BannerMsg model,LoginModel login){
		BannerMsg preModel = bannerMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getBanner()==null||model.getBanner().equals("")){
			return "轮播图为必填属性";
		}
		if(model.getBanner()!=null){
			String [] fileSplit = model.getBanner().split(";");
			if(fileSplit.length>1){
				return "轮播图的图片数量不能大于1";
			}
		}
		preModel.setBanner(model.getBanner());
		bannerMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询轮播图列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(BannerMsg queryModel,Integer pageSize,LoginModel login) {
		BannerMsgExample se = new BannerMsgExample();
		BannerMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)bannerMsgMapper.countByExample(se);
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
	*根据参数查询轮播图列表数据
	*/
	@Override
	public Map<String,Object> getDataList(BannerMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		BannerMsgExample se = new BannerMsgExample();
		BannerMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<BannerMsg> list = bannerMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(BannerMsg model:list){
			list2.add(getBannerMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装轮播图为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getBannerMsgModel(BannerMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bannerMsg",model);
		List<String> bannerList = new ArrayList<String>();
		if(model.getBanner()!=null){
			String [] bannerSplit = model.getBanner().split(";");
			for(String tmpstr:bannerSplit ){
				if(tmpstr.equals("")==false){
					bannerList.add(tmpstr);
				}
			}
		}
		map.put("bannerList",bannerList);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		bannerMsgMapper.deleteByPrimaryKey(id);
	}
}
