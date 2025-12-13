package com.foods.dao;
import com.foods.model.ReplyMsg;
import com.foods.model.ReplyMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface ReplyMsgMapper {
	long countByExample(ReplyMsgExample example);
	int deleteByExample(ReplyMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(ReplyMsg record);
	int insertSelective(ReplyMsg record);
	List<ReplyMsg> selectByExample(ReplyMsgExample example);
	ReplyMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") ReplyMsg record, @Param("example") ReplyMsgExample example);
	int updateByExample(@Param("record") ReplyMsg record, @Param("example") ReplyMsgExample example);
	int updateByPrimaryKeySelective(ReplyMsg record);
	int updateByPrimaryKey(ReplyMsg record);
}
