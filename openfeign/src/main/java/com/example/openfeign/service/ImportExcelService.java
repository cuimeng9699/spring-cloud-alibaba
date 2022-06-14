package com.example.openfeign.service;

import com.example.openfeign.dao.po.UserExtend;

import java.io.InputStream;
import java.util.List;

/**
 * @author Mr.Cui
 */
public interface ImportExcelService {
    /**
     * @param bytes
     * @Description: 导入excel
     * @Date: 6/9/22 8:36 PM
     * @Author: Mr.Cui
     * @return: List<Long>
     **/
    List<Long> importUserContext(InputStream inputStream) throws Exception;

    /**
     * @param idList
     * @Description: 导入反查
     * @Date: 6/10/22 4:23 PM
     * @Author: Mr.Cui
     * @return: List<UserExtend>
     **/
    List<UserExtend> queryUserContext(List<Long> idList);
}
