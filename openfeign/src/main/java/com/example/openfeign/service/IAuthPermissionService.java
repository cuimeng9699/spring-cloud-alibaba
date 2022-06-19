package com.example.openfeign.service;

import com.example.openfeign.dao.po.AuthPermission;
import com.example.openfeign.vo.MenuVO;
import com.example.openfeign.vo.PermissionVO;
import com.example.openfeign.vo.RoleVO;
import com.share.foreign.utils.PageResult;
import com.share.foreign.wrapper.ResponseTemplate;

import java.util.List;

/**
 * @author cuimeng
 */
public interface IAuthPermissionService {

    Boolean insert(PermissionVO permissionVO);

    PageResult<PermissionVO> page(Integer pageNum, Integer pageSize);

    List<AuthPermission> list();

    List<PermissionVO> permissionListByRoleList(List<RoleVO> roleVOS);

    List<PermissionVO> selectAllOperateAuthority();

    PermissionVO selectByPrimaryKey(Long permissionId);

    ResponseTemplate<List<MenuVO>> menuList();

    Boolean update(PermissionVO permissionVO);
}
