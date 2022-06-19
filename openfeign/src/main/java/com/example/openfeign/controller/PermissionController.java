package com.example.openfeign.controller;


import com.example.openfeign.service.IAuthPermissionService;
import com.example.openfeign.vo.PermissionVO;
import com.share.foreign.utils.PageResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private IAuthPermissionService permissionService;

    @GetMapping("/page")
    public PageResult<PermissionVO> page(Integer pageNum, Integer pageSize) {
        return permissionService.page(pageNum, pageSize);
    }

    @PostMapping("/save")
    public Boolean insert(@RequestBody PermissionVO permissionVO) {
        return permissionService.insert(permissionVO);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody PermissionVO permissionVO) {
        return permissionService.update(permissionVO);
    }

    @GetMapping("/select/id")
    public PermissionVO selectByPrimaryKey(Long permissionId) {
        return permissionService.selectByPrimaryKey(permissionId);
    }

}
