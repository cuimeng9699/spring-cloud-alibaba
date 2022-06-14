package com.example.openfeign.dao.mapper;

import com.example.openfeign.dao.po.UserExtend;
import com.example.openfeign.dao.po.UserExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExtendMapper {
    long countByExample(UserExtendExample example);

    int deleteByExample(UserExtendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserExtend record);

    int insertSelective(UserExtend record);

    UserExtend selectOneByExample(UserExtendExample example);

    List<UserExtend> selectByExample(UserExtendExample example);

    UserExtend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserExtend record, @Param("example") UserExtendExample example);

    int updateByExample(@Param("record") UserExtend record, @Param("example") UserExtendExample example);

    int updateByPrimaryKeySelective(UserExtend record);

    int updateByPrimaryKey(UserExtend record);

    int batchInsert(@Param("list") List<UserExtend> list);

    int batchInsertSelective(@Param("list") List<UserExtend> list, @Param("selective") UserExtend.Column ... selective);
}