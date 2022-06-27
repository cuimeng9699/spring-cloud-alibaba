package com.example.openfeign.service;

import java.util.List;
import java.util.Map;

/**
 * @author cuimeng
 */
public interface ICommonsService {

    /**
     * @Description: 查询统一接口不分页
     * @Date: 6/26/22 10:12 PM
     * @Author: Mr.Cui
     * @param [map]
     * @return: List<Map>
     **/
    List<Map> queryCommons(Map map);
}
