package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.AuthDepartment;
import com.example.openfeign.dao.po.AuthDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthDepartmentMapper {
    long countByExample(AuthDepartmentExample example);

    int deleteByExample(AuthDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthDepartment record);

    int insertSelective(AuthDepartment record);

    AuthDepartment selectOneByExample(AuthDepartmentExample example);

    List<AuthDepartment> selectByExample(AuthDepartmentExample example);

    AuthDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthDepartment record, @Param("example") AuthDepartmentExample example);

    int updateByExample(@Param("record") AuthDepartment record, @Param("example") AuthDepartmentExample example);

    int updateByPrimaryKeySelective(AuthDepartment record);

    int updateByPrimaryKey(AuthDepartment record);

    int batchInsert(@Param("list") List<AuthDepartment> list);

    int batchInsertSelective(@Param("list") List<AuthDepartment> list, @Param("selective") AuthDepartment.Column ... selective);
}