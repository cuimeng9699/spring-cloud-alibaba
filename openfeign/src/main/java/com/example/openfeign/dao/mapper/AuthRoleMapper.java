package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.AuthRole;
import com.example.openfeign.dao.po.AuthRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthRoleMapper {
    long countByExample(AuthRoleExample example);

    int deleteByExample(AuthRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectOneByExample(AuthRoleExample example);

    List<AuthRole> selectByExample(AuthRoleExample example);

    AuthRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    int updateByExample(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);

    int batchInsert(@Param("list") List<AuthRole> list);

    int batchInsertSelective(@Param("list") List<AuthRole> list, @Param("selective") AuthRole.Column ... selective);
}