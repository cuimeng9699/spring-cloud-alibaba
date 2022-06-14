package com.example.openfeign.service;

import com.example.openfeign.dao.po.UserExtend;
import com.example.openfeign.utils.PageResult;

/**
 * @author Mr.Cui
 */
public interface IPageQueryService {
  /**
   * @Description: 分页查询用户信息
   * @Date: 6/9/22 1:42 PM
   * @Author: Mr.Cui
   * @param [id, userName, cityName, startTime, endTime, pageSize, pageNum]
   * @return: PageResult<UserExtend>
   **/
    PageResult<UserExtend> pageQueryUserContext(Long id, String userName, String cityName, String startTime,String endTime,Integer pageSize, Integer pageNum);
}
