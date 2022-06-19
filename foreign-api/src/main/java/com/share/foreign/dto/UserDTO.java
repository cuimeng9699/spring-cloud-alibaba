package com.share.foreign.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/9/22 10:12 AM
 */
@Data
@Builder
public class UserDTO {

    private Integer id;

    private String name;

    private Date birthday;

    private String address;
}
