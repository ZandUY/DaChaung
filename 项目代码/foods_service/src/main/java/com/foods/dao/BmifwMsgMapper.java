package com.foods.dao;
import com.foods.model.BmifwMsg;
import com.foods.model.BmifwMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface BmifwMsgMapper {
	long countByExample(BmifwMsgExample example);
	int deleteByExample(BmifwMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(BmifwMsg record);
	int insertSelective(BmifwMsg record);
	List<BmifwMsg> selectByExample(BmifwMsgExample example);
	BmifwMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") BmifwMsg record, @Param("example") BmifwMsgExample example);
	int updateByExample(@Param("record") BmifwMsg record, @Param("example") BmifwMsgExample example);
	int updateByPrimaryKeySelective(BmifwMsg record);
	int updateByPrimaryKey(BmifwMsg record);
}
