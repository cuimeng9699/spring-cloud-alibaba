package com.example.openfeign.dto;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/9/22 10:12 AM
 */
@Data
public class UserDTO {

    private Integer id;

    private String name;

    private Date birthday;

    private String address;
}
