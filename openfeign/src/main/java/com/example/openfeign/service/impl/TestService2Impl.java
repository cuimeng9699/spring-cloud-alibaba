package com.example.openfeign.service.impl;

import com.example.openfeign.dao.po.User;
import com.example.openfeign.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestService2Impl
 * @Description TODO
 * @Author Mr.Cui
 * @Date 3/18/22 11:07 AM
 */
@Component("testService2Impl")
public class TestService2Impl implements TestService {
    @Override
    public String test() throws Exception{
        return "22";
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }
}
