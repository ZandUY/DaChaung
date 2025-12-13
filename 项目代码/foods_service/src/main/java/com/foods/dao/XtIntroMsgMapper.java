package com.foods.dao;
import com.foods.model.XtIntroMsg;
import com.foods.model.XtIntroMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface XtIntroMsgMapper {
	long countByExample(XtIntroMsgExample example);
	int deleteByExample(XtIntroMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(XtIntroMsg record);
	int insertSelective(XtIntroMsg record);
	List<XtIntroMsg> selectByExample(XtIntroMsgExample example);
	XtIntroMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") XtIntroMsg record, @Param("example") XtIntroMsgExample example);
	int updateByExample(@Param("record") XtIntroMsg record, @Param("example") XtIntroMsgExample example);
	int updateByPrimaryKeySelective(XtIntroMsg record);
	int updateByPrimaryKey(XtIntroMsg record);
}
