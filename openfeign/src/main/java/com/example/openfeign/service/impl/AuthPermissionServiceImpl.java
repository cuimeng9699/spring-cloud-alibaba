package com.example.openfeign.service.impl;

import com.example.openfeign.dao.mapper.extend.AuthPermissionExtMapper;
import com.example.openfeign.dao.po.AuthPermission;
import com.example.openfeign.service.IAuthPermissionService;
import com.example.openfeign.vo.MenuVO;
import com.example.openfeign.vo.PermissionVO;
import com.example.openfeign.vo.RoleVO;
import com.share.foreign.enums.PermissionTypeEnum;
import com.share.foreign.utils.Page;
import com.share.foreign.utils.PageResult;
import com.share.foreign.wrapper.ResponseTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName AuthPermissionServiceImpl
 * @Description 权限控制
 * @Author Mr.Cui
 * @Date 6/19/22 8:35 PM
 */
@Service
public class AuthPermissionServiceImpl implements IAuthPermissionService {
    @Resource
    private AuthPermissionExtMapper authPermissionExtMapper;

    @Override
    public Boolean insert(PermissionVO permissionVO) {
        AuthPermission authPermission = new AuthPermission();

        authPermission.setPermissionTag(permissionVO.getPermissionTag());
        authPermission.setPermissionName(permissionVO.getPermissionName());
        authPermission.setUrl(permissionVO.getUrl());
        authPermission.setIsDeleted(false);
        authPermission.setPermissionType(PermissionTypeEnum.getEnumByName(permissionVO.getPermissionType()).toString());
        authPermission.setParentId(permissionVO.getParentId());
        int count = authPermissionExtMapper.insertSelective(authPermission);
        return count > 0;
    }

    @Override
    public PageResult<PermissionVO> page(Integer pageNum, Integer pageSize) {
        Long count = authPermissionExtMapper.selectAllCount();
        PageResult<PermissionVO> pageResult = new PageResult<>();
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setTotalCount(count);
        pageResult.setPage(page);
        if (count < 1) {
            pageResult.setList(Collections.emptyList());
            return pageResult;
        }
        List<AuthPermission> poList = authPermissionExtMapper.selectByPage((pageNum - 1) * pageSize, pageSize);

        List<PermissionVO> vos = poList.stream().map(this::po2VO).collect(Collectors.toList());

        pageResult.setList(vos);
        return pageResult;
    }

    @Override
    public List<AuthPermission> list() {
        List<AuthPermission> poList = authPermissionExtMapper.selectAll();
        return poList;
    }

    @Override
    public List<PermissionVO> permissionListByRoleList(List<RoleVO> roleVOS) {
        /*if (CollectionUtils.isEmpty(roleVOS)) {
            return Collections.emptyList();
        }
        List<Long> roleIds = roleVOS.stream().map(RoleVO::getId).collect(Collectors.toList());

        List<AuthRolePermission> relations = authRolePermissionExtendMapper.selectByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(relations)) {
            return Collections.emptyList();
        }
        List<Long> permissionIds = relations.stream().map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        List<AuthPermission> allPermission = new ArrayList<>();
        List<AuthPermission> permissions = authPermissionExtMapper.selectByIds(permissionIds);
        allPermission.addAll(permissions);
        List<Long> parentIdList = new ArrayList<>();
        for (AuthPermission permission : permissions) {
            parentIdList.add(permission.getId());
        }
        if (!CollectionUtils.isEmpty(parentIdList)) {
            List<AuthPermission> authPermissions = authPermissionExtMapper.selectAuthPermissionByParentIdList(parentIdList);
            allPermission.addAll(authPermissions);
        }
        if (CollectionUtils.isEmpty(allPermission)) {
            return Collections.emptyList();
        }
        List<PermissionVO> result = allPermission.stream().map(p -> {
            PermissionVO permissionVO = po2VO(p);
            return permissionVO;
        }).collect(Collectors.toList());*/
        return null;
    }

    @Override
    public List<PermissionVO> selectAllOperateAuthority() {
        return null;
    }

    @Override
    public PermissionVO selectByPrimaryKey(Long permissionId) {
        return null;
    }

    @Override
    public ResponseTemplate<List<MenuVO>> menuList() {
        return null;
    }

    @Override
    public Boolean update(PermissionVO permissionVO) {
        return null;
    }

    public PermissionVO po2VO(AuthPermission po) {
        PermissionVO permissionVO = new PermissionVO();
        permissionVO.setPermissionName(po.getPermissionName());
        permissionVO.setId(po.getId());
        permissionVO.setPermissionTag(po.getPermissionTag());
        permissionVO.setUrl(po.getUrl());
        permissionVO.setPermissionType(po.getPermissionType() != null ? po.getPermissionType() : null);
        permissionVO.setParentId(po.getParentId());
        return permissionVO;
    }

}
