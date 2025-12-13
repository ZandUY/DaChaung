package com.foods.dao;
import com.foods.model.YyxcsMsg;
import com.foods.model.YyxcsMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YyxcsMsgMapper {
	long countByExample(YyxcsMsgExample example);
	int deleteByExample(YyxcsMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YyxcsMsg record);
	int insertSelective(YyxcsMsg record);
	List<YyxcsMsg> selectByExample(YyxcsMsgExample example);
	YyxcsMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YyxcsMsg record, @Param("example") YyxcsMsgExample example);
	int updateByExample(@Param("record") YyxcsMsg record, @Param("example") YyxcsMsgExample example);
	int updateByPrimaryKeySelective(YyxcsMsg record);
	int updateByPrimaryKey(YyxcsMsg record);
}
