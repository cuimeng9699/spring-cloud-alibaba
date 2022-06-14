package com.example.openfeign.dao.mapper.extend;

import com.example.openfeign.dao.mapper.UserExtendMapper;
import com.example.openfeign.dao.po.UserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserExtendExtMapper extends UserExtendMapper {
    /**
     * @param [id, userName, cityName, startTime, endTime]
     * @Description: 根据条件查询用户表数量
     * @Date: 6/9/22 1:32 PM
     * @Author: cuimeng
     * @return: Long
     **/
    Long queryUserContextCount(@Param("id") Long id,
                               @Param("userName") String userName,
                               @Param("cityName") String cityName,
                               @Param("startTime") String startTime,
                               @Param("endTime") String endTime);

    /**
     * @param [id, userName, cityName, startTime, endTime, offset, limit]
     * @Description: 根据条件查询用户表数据
     * @Date: 6/9/22 1:36 PM
     * @Author: cuimeng
     * @return: List<UserExtend>
     **/
    List<UserExtend> pageQueryUserContext(@Param("id") Long id,
                                          @Param("userName") String userName,
                                          @Param("cityName") String cityName,
                                          @Param("startTime") String startTime,
                                          @Param("endTime") String endTime,
                                          @Param("offset") Integer offset,
                                          @Param("limit") Integer limit);

    Integer updateIsDeleteByIdList(@Param("idList")List<Long> idList, @Param("isDelete")Boolean isDelete);
}