package com.example.openfeign.dao.mapper.extend;

import com.example.openfeign.dao.mapper.AuthPermissionMapper;
import com.example.openfeign.dao.po.AuthPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr.Cui
 */
public interface AuthPermissionExtMapper extends AuthPermissionMapper {

    List<AuthPermission> selectByPermissionTags(List<String> permissionTags);

    /**
     * 根据id 批量查询
     *
     * @param ids ids
     * @return
     */
    List<AuthPermission> selectByIds(@Param("ids") List<Long> ids);

    List<AuthPermission> selectAll();

    Long selectAllCount();

    /**
     * 查询操作权限
     *
     * @param ids
     * @return
     */
    List<AuthPermission> selectOperateAuthority(@Param("ids") List<Long> ids);

    List<AuthPermission> selectByPage(@Param("offset") Integer offset, @Param("limit") Integer limit);

    List<AuthPermission> selectAuthPermissionByParentId(Long parentId);

    List<AuthPermission> selectAuthPermissionByParentIdList(@Param("parentIdList") List<Long> parentIdList);

    AuthPermission selectByPermissionTag(String permissionTag);
}