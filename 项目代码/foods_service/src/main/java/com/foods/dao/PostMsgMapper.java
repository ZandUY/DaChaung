package com.foods.dao;
import com.foods.model.PostMsg;
import com.foods.model.PostMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface PostMsgMapper {
	long countByExample(PostMsgExample example);
	int deleteByExample(PostMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(PostMsg record);
	int insertSelective(PostMsg record);
	List<PostMsg> selectByExample(PostMsgExample example);
	PostMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") PostMsg record, @Param("example") PostMsgExample example);
	int updateByExample(@Param("record") PostMsg record, @Param("example") PostMsgExample example);
	int updateByPrimaryKeySelective(PostMsg record);
	int updateByPrimaryKey(PostMsg record);
}
