package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.AuthRolePermission;
import com.example.openfeign.dao.po.AuthRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthRolePermissionMapper {
    long countByExample(AuthRolePermissionExample example);

    int deleteByExample(AuthRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthRolePermission record);

    int insertSelective(AuthRolePermission record);

    AuthRolePermission selectOneByExample(AuthRolePermissionExample example);

    List<AuthRolePermission> selectByExample(AuthRolePermissionExample example);

    AuthRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthRolePermission record, @Param("example") AuthRolePermissionExample example);

    int updateByExample(@Param("record") AuthRolePermission record, @Param("example") AuthRolePermissionExample example);

    int updateByPrimaryKeySelective(AuthRolePermission record);

    int updateByPrimaryKey(AuthRolePermission record);

    int batchInsert(@Param("list") List<AuthRolePermission> list);

    int batchInsertSelective(@Param("list") List<AuthRolePermission> list, @Param("selective") AuthRolePermission.Column ... selective);
}