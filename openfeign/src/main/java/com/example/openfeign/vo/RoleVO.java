package com.example.openfeign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO implements Serializable {

    private static final long serialVersionUID = -4076434818508350573L;
    private Long id;

    private String code;

    private Long deptId;

    private String nameCh;

    private String createTime;

    private String updateTime;

    private Boolean isDeleted;
}
