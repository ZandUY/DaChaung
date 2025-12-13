package com.foods.dao;
import com.foods.model.YsjhMsg;
import com.foods.model.YsjhMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YsjhMsgMapper {
	long countByExample(YsjhMsgExample example);
	int deleteByExample(YsjhMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YsjhMsg record);
	int insertSelective(YsjhMsg record);
	List<YsjhMsg> selectByExample(YsjhMsgExample example);
	YsjhMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YsjhMsg record, @Param("example") YsjhMsgExample example);
	int updateByExample(@Param("record") YsjhMsg record, @Param("example") YsjhMsgExample example);
	int updateByPrimaryKeySelective(YsjhMsg record);
	int updateByPrimaryKey(YsjhMsg record);
}
