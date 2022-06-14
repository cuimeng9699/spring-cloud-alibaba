package com.example.openfeign.controller;

import com.example.openfeign.dao.po.UserExtend;
import com.example.openfeign.service.IPageQueryService;
import com.example.openfeign.utils.PageResult;
import com.example.openfeign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PageQueryController
 * @Description 分页查询
 * @Author Mr.Cui
 * @Date 6/9/22 10:47 AM
 */
@RestController
@RequestMapping("/page")
@Slf4j
public class PageQueryController {

    @Resource
    private IPageQueryService pageQueryService;

    /**
     * @param [id, userName, cityName, pageSize, pageNum]
     * @Description: 分页查询用户信息 用户名称模糊匹配 根据开始时间结束时间
     * @Date: 6/9/22 1:15 PM
     * @Author: Mr.Cui
     * @return: ResponseTemplate<PageResult < UserExtend>>
     **/
    @GetMapping("/pageQueryUserContext")
    public ResponseTemplate<PageResult<UserExtend>> pageQueryUserContext(Long id, String userName, String cityName, String startTime, String endTime,
                                                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                                         @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
        PageResult<UserExtend> pageResult = pageQueryService.pageQueryUserContext(id, userName, cityName, startTime, endTime, pageSize, pageNum);
        return ResponseTemplate.buildSuccessResult(pageResult);
    }
}
