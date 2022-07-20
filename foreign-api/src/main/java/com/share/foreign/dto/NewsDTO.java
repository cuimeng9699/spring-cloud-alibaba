package com.share.foreign.dto;


import com.share.foreign.enums.WebSocketTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cuimeng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {
    /**
     * 消息数量
     */
    Integer newNum;
    /**
     * 消息
     * {@link WebSocketTypeEnum}
     */
    Integer wsType;
    /**
     * 用户id
     */
    String token;
    /**
     * 会议室id
     */
    String sessionId;
    /**
     * 消息id
     */
    Long newId;
    /**
     * 时间戳 单位:秒
     */
    Long timestamp;
}
