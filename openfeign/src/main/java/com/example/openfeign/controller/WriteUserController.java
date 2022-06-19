package com.example.openfeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.share.foreign.dto.UserExtendDTO;
import com.example.openfeign.service.IWriteUserService;
import com.share.foreign.wrapper.BaseDTO;
import com.share.foreign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName WriteUserController
 * @Description 增删改用户信息
 * @Author Mr.Cui
 * @Date 6/9/22 2:28 PM
 */
@RestController
@RequestMapping("/write")
@Slf4j
public class WriteUserController {

    @Resource
    private IWriteUserService writeUserService;
    /**
     * @Description: 根据id删除用户信息
     * @Date: 6/9/22 2:55 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: ResponseTemplate<Boolean>
     **/
    @PostMapping("/deleteUserById")
    public ResponseTemplate<Boolean> deleteUserById (@RequestBody BaseDTO<UserExtendDTO> userExtendDTO){
        log.info("请求头数据信息为{}:", JSONObject.toJSONString(userExtendDTO));
        Boolean delete = writeUserService.deleteUserById(userExtendDTO.getBody());
        return ResponseTemplate.buildSuccessResult(delete);
    }

    /**
     * @Description: 根据idList 批量删除用户信息
     * @Date: 6/9/22 2:56 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: ResponseTemplate<Boolean>
     **/
    @PostMapping("/deleteUserByIdList")
    public ResponseTemplate<Boolean> deleteUserByIdList (@RequestBody BaseDTO<UserExtendDTO> userExtendDTO){
        log.info("请求头数据信息为{}:", JSONObject.toJSONString(userExtendDTO));
        Boolean delete = writeUserService.deleteUserByIdList(userExtendDTO.getBody());
        return ResponseTemplate.buildSuccessResult(delete);
    }

    /**
     * @Description: 根据用户id修改用户信息
     * @Date: 6/9/22 3:14 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: ResponseTemplate<Boolean>
     **/
    @PostMapping("/updateUserById")
    public ResponseTemplate<Boolean> updateUserById (@RequestBody BaseDTO<UserExtendDTO> userExtendDTO){
        log.info("请求头数据信息为{}:", JSONObject.toJSONString(userExtendDTO));
        Boolean update = writeUserService.updateUserById(userExtendDTO.getBody());
        return ResponseTemplate.buildSuccessResult(update);
    }

    /**
     * @Description: 添加用户信息
     * @Date: 6/9/22 3:32 PM
     * @Author: Mr.Cui
     * @param userExtendDTO
     * @return: ResponseTemplate<Boolean>
     **/
    @PostMapping("insertUserContext")
    public ResponseTemplate<Boolean> insertUserContext (@RequestBody BaseDTO<UserExtendDTO> userExtendDTO){
        log.info("请求头数据信息为{}:", JSONObject.toJSONString(userExtendDTO));
        Boolean insert = writeUserService.insertUserContext(userExtendDTO.getBody());
        return ResponseTemplate.buildSuccessResult(insert);
    }
}
