package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.AuthUser;
import com.example.openfeign.dao.po.AuthUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthUserMapper {
    long countByExample(AuthUserExample example);

    int deleteByExample(AuthUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    AuthUser selectOneByExample(AuthUserExample example);

    List<AuthUser> selectByExample(AuthUserExample example);

    AuthUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    int updateByExample(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKey(AuthUser record);

    int batchInsert(@Param("list") List<AuthUser> list);

    int batchInsertSelective(@Param("list") List<AuthUser> list, @Param("selective") AuthUser.Column ... selective);
}