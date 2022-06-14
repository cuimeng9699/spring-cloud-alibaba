package com.example.openfeign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName UserExtendDTO
 * @Description 用户信息
 * @Author Mr.Cui
 * @Date 6/9/22 2:31 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserExtendDTO {

    private Long id;

    private Long userId;

    private String userName;

    private Integer cityId;

    private String cityName;

    private Integer areaId;

    private String areaName;

    private List<Long> idList;
}
