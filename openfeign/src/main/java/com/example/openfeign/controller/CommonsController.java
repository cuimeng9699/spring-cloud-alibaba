package com.example.openfeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.openfeign.service.ICommonsService;
import com.share.foreign.wrapper.BaseDTO;
import com.share.foreign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName CommonsController
 * @Description 公共接口
 * @Author Mr.Cui
 * @Date 6/26/22 10:09 PM
 */
@RestController
@RequestMapping("/commons")
@Slf4j
public class CommonsController {

    @Resource
    private ICommonsService commonsService;
    /**
     * test database
     *
     * @return
     */
    @PostMapping(value = "/queryCommons")
    public ResponseTemplate<Map> queryCommons(@RequestBody BaseDTO<Map> request) {
        log.info("请求头数据信息为{}:", JSONObject.toJSONString(request));
        Map resultMap = commonsService.queryCommons(request.getBody());
        return ResponseTemplate.buildSuccessResult(resultMap);
    }

}
