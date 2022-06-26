package com.example.openfeign.controller;

import com.example.openfeign.service.CommonsService;
import com.share.foreign.wrapper.BaseDTO;
import com.share.foreign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
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
    private CommonsService commonsService;
    /**
     * test database
     *
     * @return
     */
    @PostMapping(value = "/queryCommons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplate<List<Map>> queryCommons(@RequestBody BaseDTO<Map> request) {
        List<Map> resultListMap = commonsService.queryCommons(request.getBody());
        return ResponseTemplate.buildSuccessResult(resultListMap);
    }

}
