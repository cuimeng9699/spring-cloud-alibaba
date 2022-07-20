package com.share.foreign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.websocket.Session;

/**
 * 用户id 和用户的WebSocket长链接信息
 *
 * @author cuimeng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionDTO {
    /**
     * 登录用户的长链接
     */
    Session session;
    /**
     * 用户的uid
     */
    Long userId;

    Long cityId;
}
