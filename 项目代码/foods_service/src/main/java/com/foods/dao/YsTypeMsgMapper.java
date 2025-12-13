package com.foods.dao;
import com.foods.model.YsTypeMsg;
import com.foods.model.YsTypeMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YsTypeMsgMapper {
	long countByExample(YsTypeMsgExample example);
	int deleteByExample(YsTypeMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YsTypeMsg record);
	int insertSelective(YsTypeMsg record);
	List<YsTypeMsg> selectByExample(YsTypeMsgExample example);
	YsTypeMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YsTypeMsg record, @Param("example") YsTypeMsgExample example);
	int updateByExample(@Param("record") YsTypeMsg record, @Param("example") YsTypeMsgExample example);
	int updateByPrimaryKeySelective(YsTypeMsg record);
	int updateByPrimaryKey(YsTypeMsg record);
}
