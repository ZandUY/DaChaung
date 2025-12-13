package com.foods.dao;
import com.foods.model.YsLog;
import com.foods.model.YsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YsLogMapper {
	long countByExample(YsLogExample example);
	int deleteByExample(YsLogExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YsLog record);
	int insertSelective(YsLog record);
	List<YsLog> selectByExample(YsLogExample example);
	YsLog selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YsLog record, @Param("example") YsLogExample example);
	int updateByExample(@Param("record") YsLog record, @Param("example") YsLogExample example);
	int updateByPrimaryKeySelective(YsLog record);
	int updateByPrimaryKey(YsLog record);
}
