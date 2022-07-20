package com.share.foreign.enums;

import lombok.Getter;


/**
 * @author cuimeng
 */

@Getter
public enum WebSocketTypeEnum {
    /**
     * 部门类型枚举
     */
    // 心跳 2:有未接听的[心跳的情况返回] , 3 无未接听的[心跳的情况返回] 4:新消息 [新消息推送] 5 不需要创建长链接    on(1, "心跳"),
    on(1, "心跳"),
    have(2, "有未接听的消息，新来消息"),
    not_have(3, "无未接听的消息"),
    off(4, "不需要创建长链接"),
    connect(5, "通话中断需重连"),
    disconnect(6, "发起人主动挂断"),
    logout(7, "用户退出登陆"),
    reservation(8, "预约接听");

    private Integer code;
    private String desc;

    WebSocketTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
