package com.foods.dao;
import com.foods.model.DisMsg;
import com.foods.model.DisMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface DisMsgMapper {
	long countByExample(DisMsgExample example);
	int deleteByExample(DisMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(DisMsg record);
	int insertSelective(DisMsg record);
	List<DisMsg> selectByExample(DisMsgExample example);
	DisMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") DisMsg record, @Param("example") DisMsgExample example);
	int updateByExample(@Param("record") DisMsg record, @Param("example") DisMsgExample example);
	int updateByPrimaryKeySelective(DisMsg record);
	int updateByPrimaryKey(DisMsg record);
}
