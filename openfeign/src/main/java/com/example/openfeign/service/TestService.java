package com.example.openfeign.service;

import com.example.openfeign.dao.po.User;

/**
 * @ClassName TestService
 * @Description TODO
 * @Author cuimeng
 * @Date 3/18/22 11:05 AM
 */
public interface TestService {
    String test() throws Exception;

    User getUserById(Integer id);
}
