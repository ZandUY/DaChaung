package com.foods.dao;
import com.foods.model.YdLog;
import com.foods.model.YdLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YdLogMapper {
	long countByExample(YdLogExample example);
	int deleteByExample(YdLogExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YdLog record);
	int insertSelective(YdLog record);
	List<YdLog> selectByExample(YdLogExample example);
	YdLog selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YdLog record, @Param("example") YdLogExample example);
	int updateByExample(@Param("record") YdLog record, @Param("example") YdLogExample example);
	int updateByPrimaryKeySelective(YdLog record);
	int updateByPrimaryKey(YdLog record);
}
