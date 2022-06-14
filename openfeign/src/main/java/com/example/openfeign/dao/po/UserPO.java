package com.example.openfeign.dao.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserPO
 * @Description TODO
 * @Author cuimeng
 * @Date 6/7/22 7:58 PM
 */
@Data
@Builder
public class UserPO implements Serializable {
    private Integer id;
    private String name;
    private Date birthday;
    private String address;
}
