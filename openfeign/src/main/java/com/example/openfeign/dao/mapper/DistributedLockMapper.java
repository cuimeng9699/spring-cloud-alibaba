package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.DistributedLock;
import com.example.openfeign.dao.po.DistributedLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistributedLockMapper {
    long countByExample(DistributedLockExample example);

    int deleteByExample(DistributedLockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DistributedLock record);

    int insertSelective(DistributedLock record);

    DistributedLock selectOneByExample(DistributedLockExample example);

    List<DistributedLock> selectByExample(DistributedLockExample example);

    DistributedLock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DistributedLock record, @Param("example") DistributedLockExample example);

    int updateByExample(@Param("record") DistributedLock record, @Param("example") DistributedLockExample example);

    int updateByPrimaryKeySelective(DistributedLock record);

    int updateByPrimaryKey(DistributedLock record);

    int batchInsert(@Param("list") List<DistributedLock> list);

    int batchInsertSelective(@Param("list") List<DistributedLock> list, @Param("selective") DistributedLock.Column ... selective);
}