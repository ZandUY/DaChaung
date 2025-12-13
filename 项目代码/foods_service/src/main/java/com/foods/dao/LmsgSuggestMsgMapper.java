package com.foods.dao;
import com.foods.model.LmsgSuggestMsg;
import com.foods.model.LmsgSuggestMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface LmsgSuggestMsgMapper {
	long countByExample(LmsgSuggestMsgExample example);
	int deleteByExample(LmsgSuggestMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(LmsgSuggestMsg record);
	int insertSelective(LmsgSuggestMsg record);
	List<LmsgSuggestMsg> selectByExample(LmsgSuggestMsgExample example);
	LmsgSuggestMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") LmsgSuggestMsg record, @Param("example") LmsgSuggestMsgExample example);
	int updateByExample(@Param("record") LmsgSuggestMsg record, @Param("example") LmsgSuggestMsgExample example);
	int updateByPrimaryKeySelective(LmsgSuggestMsg record);
	int updateByPrimaryKey(LmsgSuggestMsg record);
}
