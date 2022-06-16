package com.example.openfeign.service.impl;

import com.example.openfeign.service.AbstractService;
import lombok.Setter;

/**
 * @ClassName AbstractServiceImpl
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/16/22 2:35 PM
 */
@Setter
abstract class AbstractServiceImpl implements AbstractService {

    @Override
    public String test() {
        return "123";
    }
}
