package com.example.openfeign.service;

import java.util.Map;

/**
 * @author cuimeng
 */
public interface ICommonsService {

    /**
     * @Description: 查询统一接口不分页
     * @Date: 6/26/22 10:12 PM
     * @Author: Mr.Cui
     * @param map
     * @return: List<Map>
     **/
    Map queryCommons(Map map);
}
