package com.windaka.suizhi.mpi.dao.auto;

import com.windaka.suizhi.mpi.model.BaseCommunity;
import com.windaka.suizhi.mpi.model.BaseCommunityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BaseCommunityMapper {
    int countByExample(BaseCommunityExample example);

    int deleteByExample(BaseCommunityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseCommunity record);

    int insertSelective(BaseCommunity record);

    List<BaseCommunity> selectByExample(BaseCommunityExample example);

    BaseCommunity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseCommunity record, @Param("example") BaseCommunityExample example);

    int updateByExample(@Param("record") BaseCommunity record, @Param("example") BaseCommunityExample example);

    int updateByPrimaryKeySelective(BaseCommunity record);

    int updateByPrimaryKey(BaseCommunity record);
}