package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.OperationSqlConfig;
import com.example.openfeign.dao.po.OperationSqlConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationSqlConfigMapper {
    long countByExample(OperationSqlConfigExample example);

    int deleteByExample(OperationSqlConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OperationSqlConfig record);

    int insertSelective(OperationSqlConfig record);

    OperationSqlConfig selectOneByExample(OperationSqlConfigExample example);

    List<OperationSqlConfig> selectByExample(OperationSqlConfigExample example);

    OperationSqlConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OperationSqlConfig record, @Param("example") OperationSqlConfigExample example);

    int updateByExample(@Param("record") OperationSqlConfig record, @Param("example") OperationSqlConfigExample example);

    int updateByPrimaryKeySelective(OperationSqlConfig record);

    int updateByPrimaryKey(OperationSqlConfig record);

    int batchInsert(@Param("list") List<OperationSqlConfig> list);

    int batchInsertSelective(@Param("list") List<OperationSqlConfig> list, @Param("selective") OperationSqlConfig.Column ... selective);
}