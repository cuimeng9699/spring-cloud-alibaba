package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.AuthUserRole;
import com.example.openfeign.dao.po.AuthUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthUserRoleMapper {
    long countByExample(AuthUserRoleExample example);

    int deleteByExample(AuthUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthUserRole record);

    int insertSelective(AuthUserRole record);

    AuthUserRole selectOneByExample(AuthUserRoleExample example);

    List<AuthUserRole> selectByExample(AuthUserRoleExample example);

    AuthUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthUserRole record, @Param("example") AuthUserRoleExample example);

    int updateByExample(@Param("record") AuthUserRole record, @Param("example") AuthUserRoleExample example);

    int updateByPrimaryKeySelective(AuthUserRole record);

    int updateByPrimaryKey(AuthUserRole record);

    int batchInsert(@Param("list") List<AuthUserRole> list);

    int batchInsertSelective(@Param("list") List<AuthUserRole> list, @Param("selective") AuthUserRole.Column ... selective);
}