package com.example.openfeign.service;

import java.util.Map;

/**
 * @author Mr.Cui
 */
public interface IExportExcelService {
    /**
     * @param [id, userName, cityName, startTime, endTime]
     * @Description: 导出excel 用户信息
     * @Date: 6/9/22 5:21 PM
     * @Author: Mr.Cui
     * @return: Map<String, Object>
     **/
    Map<String, Object> exportUserContext(Long id, String userName, String cityName, String startTime, String endTime) throws Exception;
}
