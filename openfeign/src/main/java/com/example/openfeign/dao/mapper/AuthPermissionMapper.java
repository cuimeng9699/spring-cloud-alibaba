package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.AuthPermission;
import com.example.openfeign.dao.po.AuthPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthPermissionMapper {
    long countByExample(AuthPermissionExample example);

    int deleteByExample(AuthPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthPermission record);

    int insertSelective(AuthPermission record);

    AuthPermission selectOneByExample(AuthPermissionExample example);

    List<AuthPermission> selectByExample(AuthPermissionExample example);

    AuthPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthPermission record, @Param("example") AuthPermissionExample example);

    int updateByExample(@Param("record") AuthPermission record, @Param("example") AuthPermissionExample example);

    int updateByPrimaryKeySelective(AuthPermission record);

    int updateByPrimaryKey(AuthPermission record);

    int batchInsert(@Param("list") List<AuthPermission> list);

    int batchInsertSelective(@Param("list") List<AuthPermission> list, @Param("selective") AuthPermission.Column ... selective);
}