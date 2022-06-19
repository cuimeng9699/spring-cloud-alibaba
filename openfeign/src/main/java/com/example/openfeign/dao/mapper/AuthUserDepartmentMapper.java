package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.AuthUserDepartment;
import com.example.openfeign.dao.po.AuthUserDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthUserDepartmentMapper {
    long countByExample(AuthUserDepartmentExample example);

    int deleteByExample(AuthUserDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthUserDepartment record);

    int insertSelective(AuthUserDepartment record);

    AuthUserDepartment selectOneByExample(AuthUserDepartmentExample example);

    List<AuthUserDepartment> selectByExample(AuthUserDepartmentExample example);

    AuthUserDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthUserDepartment record, @Param("example") AuthUserDepartmentExample example);

    int updateByExample(@Param("record") AuthUserDepartment record, @Param("example") AuthUserDepartmentExample example);

    int updateByPrimaryKeySelective(AuthUserDepartment record);

    int updateByPrimaryKey(AuthUserDepartment record);

    int batchInsert(@Param("list") List<AuthUserDepartment> list);

    int batchInsertSelective(@Param("list") List<AuthUserDepartment> list, @Param("selective") AuthUserDepartment.Column ... selective);
}