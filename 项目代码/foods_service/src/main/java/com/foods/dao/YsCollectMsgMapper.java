package com.foods.dao;
import com.foods.model.YsCollectMsg;
import com.foods.model.YsCollectMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface YsCollectMsgMapper {
	long countByExample(YsCollectMsgExample example);
	int deleteByExample(YsCollectMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(YsCollectMsg record);
	int insertSelective(YsCollectMsg record);
	List<YsCollectMsg> selectByExample(YsCollectMsgExample example);
	YsCollectMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") YsCollectMsg record, @Param("example") YsCollectMsgExample example);
	int updateByExample(@Param("record") YsCollectMsg record, @Param("example") YsCollectMsgExample example);
	int updateByPrimaryKeySelective(YsCollectMsg record);
	int updateByPrimaryKey(YsCollectMsg record);
}
