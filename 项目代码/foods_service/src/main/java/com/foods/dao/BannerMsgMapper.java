package com.foods.dao;
import com.foods.model.BannerMsg;
import com.foods.model.BannerMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface BannerMsgMapper {
	long countByExample(BannerMsgExample example);
	int deleteByExample(BannerMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(BannerMsg record);
	int insertSelective(BannerMsg record);
	List<BannerMsg> selectByExample(BannerMsgExample example);
	BannerMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") BannerMsg record, @Param("example") BannerMsgExample example);
	int updateByExample(@Param("record") BannerMsg record, @Param("example") BannerMsgExample example);
	int updateByPrimaryKeySelective(BannerMsg record);
	int updateByPrimaryKey(BannerMsg record);
}
