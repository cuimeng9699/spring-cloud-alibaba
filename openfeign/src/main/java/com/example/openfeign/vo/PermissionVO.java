package com.example.openfeign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionVO implements Serializable {
    private static final long serialVersionUID = 4016312241688244443L;
    private Long id;
    private String url;
    private String permissionType;
    private Long parentId;
    private String menuName;
    private String permissionTag;
    private String permissionName;
    private Integer sortNumber;
    private String createTime;
    private String updateTime;
    private Boolean isDeleted;

    /**
     * 是否是操作权限（1是0否）
     */
    private Integer isOperateAuthority;


    /**
     * 0默认1警情管理2管理员设置3便民服务4统计
     */
    private Integer type;

    /**
     * 类型名称
     */
    private String typeName;


}
