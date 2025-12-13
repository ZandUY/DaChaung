package com.foods.dao;
import com.foods.model.YdCollectMsg;
import com.foods.model.YdCollectMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YdCollectMsgMapper {
	long countByExample(YdCollectMsgExample example);
	int deleteByExample(YdCollectMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YdCollectMsg record);
	int insertSelective(YdCollectMsg record);
	List<YdCollectMsg> selectByExample(YdCollectMsgExample example);
	YdCollectMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YdCollectMsg record, @Param("example") YdCollectMsgExample example);
	int updateByExample(@Param("record") YdCollectMsg record, @Param("example") YdCollectMsgExample example);
	int updateByPrimaryKeySelective(YdCollectMsg record);
	int updateByPrimaryKey(YdCollectMsg record);
}
