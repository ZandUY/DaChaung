package com.foods.dao;
import com.foods.model.YdxhfwMsg;
import com.foods.model.YdxhfwMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YdxhfwMsgMapper {
	long countByExample(YdxhfwMsgExample example);
	int deleteByExample(YdxhfwMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YdxhfwMsg record);
	int insertSelective(YdxhfwMsg record);
	List<YdxhfwMsg> selectByExample(YdxhfwMsgExample example);
	YdxhfwMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YdxhfwMsg record, @Param("example") YdxhfwMsgExample example);
	int updateByExample(@Param("record") YdxhfwMsg record, @Param("example") YdxhfwMsgExample example);
	int updateByPrimaryKeySelective(YdxhfwMsg record);
	int updateByPrimaryKey(YdxhfwMsg record);
}
