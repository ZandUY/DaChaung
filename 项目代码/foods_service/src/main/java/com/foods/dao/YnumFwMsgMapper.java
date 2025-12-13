package com.foods.dao;
import com.foods.model.YnumFwMsg;
import com.foods.model.YnumFwMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YnumFwMsgMapper {
	long countByExample(YnumFwMsgExample example);
	int deleteByExample(YnumFwMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YnumFwMsg record);
	int insertSelective(YnumFwMsg record);
	List<YnumFwMsg> selectByExample(YnumFwMsgExample example);
	YnumFwMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YnumFwMsg record, @Param("example") YnumFwMsgExample example);
	int updateByExample(@Param("record") YnumFwMsg record, @Param("example") YnumFwMsgExample example);
	int updateByPrimaryKeySelective(YnumFwMsg record);
	int updateByPrimaryKey(YnumFwMsg record);
}
