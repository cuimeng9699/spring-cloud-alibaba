package com.example.openfeign.service.impl;

import com.example.openfeign.dao.mapper.extend.UserExtMapper;
import com.example.openfeign.dao.po.User;
import com.example.openfeign.enums.systemEnums.ErrorCode;
import com.example.openfeign.exception.BaseException;
import com.example.openfeign.service.TestService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.openfeign.enums.systemEnums.ErrorCode.BIZ_ERROR;

/**
 * @ClassName TestServiceImpl
 * @Description TODO
 * @Author Mr.Cui
 * @Date 3/18/22 11:06 AM
 */
@Component("testServiceImpl")
public class TestServiceImpl implements TestService {

    @Resource
    private UserExtMapper userExtMapper;
    @Override
    public String test() throws Exception{
        List<String> objects = new ArrayList<>();
        if (objects.size()==0){
            throw new BaseException(BIZ_ERROR);
        }else {
            return "11";
        }

    }

    @Override
    public User getUserById(Integer id) {
        User user = userExtMapper.selectByPrimaryKey(id);
        if (Objects.isNull(user)){
            throw new BaseException(ErrorCode.NOT_FOUND);
        }
        return user;
    }
}
