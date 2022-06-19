package com.example.openfeign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO implements Serializable {

    private static final long serialVersionUID = -3266808403325125469L;
    private Long id;
    private String url;
    private String urlName;
    private String menuName;
    private List<MenuVO> children;


}
