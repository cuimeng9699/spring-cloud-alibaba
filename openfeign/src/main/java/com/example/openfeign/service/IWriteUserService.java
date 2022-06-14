package com.example.openfeign.service;

import com.example.openfeign.dto.UserExtendDTO;

/**
 * @author Mr.Cui
 */
public interface IWriteUserService {
    /**
     * @Description: 根据id删除用户信息数据
     * @Date: 6/9/22 2:36 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: Boolean
     **/
    Boolean deleteUserById(UserExtendDTO userExtendDTO);
    /**
     * @Description: 根据idList批量删除用户信息
     * @Date: 6/9/22 2:57 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: Boolean
     **/
    Boolean deleteUserByIdList(UserExtendDTO userExtendDTO);
    /**
     * @Description: 根据id修改用户信息
     * @Date: 6/9/22 3:15 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: Boolean
     **/
    Boolean updateUserById(UserExtendDTO userExtendDTO);
    /**
     * @Description: 添加用户信息
     * @Date: 6/9/22 3:33 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: Boolean
     **/
    Boolean insertUserContext(UserExtendDTO userExtendDTO);
}
