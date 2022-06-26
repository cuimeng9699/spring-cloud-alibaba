package com.example.openfeign.dao.mapper.extend;

import com.example.openfeign.dao.mapper.UserMapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserExtMapper
 * @Description TODO
 * @Author cuimeng
 * @Date 6/8/22 8:41 PM
 */
public interface UserExtMapper extends UserMapper {
    List<Map> getSql (String sql);

    void delete(Map map);
}
