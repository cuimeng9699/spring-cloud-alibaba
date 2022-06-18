package com.share.foreign.enums;

import lombok.Getter;

/**
 * @author cuimeng
 */
@Getter
public enum UserStatesEnum {

    NORMAL(1, "正常"),
    DEACTIVATE(2, "停用"),
    CANCELLATION(3, "注销");

    private Integer code;
    private String text;

    UserStatesEnum(Integer id, String text) {
        this.code = id;
        this.text = text;
    }
}
