package com.foods.dao;
import com.foods.model.YdjhMsg;
import com.foods.model.YdjhMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YdjhMsgMapper {
	long countByExample(YdjhMsgExample example);
	int deleteByExample(YdjhMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YdjhMsg record);
	int insertSelective(YdjhMsg record);
	List<YdjhMsg> selectByExample(YdjhMsgExample example);
	YdjhMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YdjhMsg record, @Param("example") YdjhMsgExample example);
	int updateByExample(@Param("record") YdjhMsg record, @Param("example") YdjhMsgExample example);
	int updateByPrimaryKeySelective(YdjhMsg record);
	int updateByPrimaryKey(YdjhMsg record);
}
