package com.example.openfeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.openfeign.service.ICommonsService;
import com.share.foreign.api.CommonsRemoteService;
import com.share.foreign.wrapper.BaseDTO;
import com.share.foreign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName CommonsController
 * @Description 公共接口
 * @Author Mr.Cui
 * @Date 6/26/22 10:09 PM
 */
@Controller
@Slf4j
public class CommonsController implements CommonsRemoteService {

    @Resource
    private ICommonsService commonsService;

    /**
     * @Description: TODO
     * @Date: 7/20/22 9:41 AM
     * @Author: Mr.Cui
     * @param requestMap
     * @return: ResponseTemplate<Map>
     **/
    @Override
    public ResponseTemplate<Map> queryCommons(@RequestBody BaseDTO<Map> requestMap) {
        log.info("请求头数据信息为{}:", JSONObject.toJSONString(requestMap));
        Map resultMap = commonsService.queryCommons(requestMap.getBody());
        return ResponseTemplate.buildSuccessResult(resultMap);
    }

}
