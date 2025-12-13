package com.foods.dao;
import com.foods.model.YdTypeMsg;
import com.foods.model.YdTypeMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YdTypeMsgMapper {
	long countByExample(YdTypeMsgExample example);
	int deleteByExample(YdTypeMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YdTypeMsg record);
	int insertSelective(YdTypeMsg record);
	List<YdTypeMsg> selectByExample(YdTypeMsgExample example);
	YdTypeMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YdTypeMsg record, @Param("example") YdTypeMsgExample example);
	int updateByExample(@Param("record") YdTypeMsg record, @Param("example") YdTypeMsgExample example);
	int updateByPrimaryKeySelective(YdTypeMsg record);
	int updateByPrimaryKey(YdTypeMsg record);
}
