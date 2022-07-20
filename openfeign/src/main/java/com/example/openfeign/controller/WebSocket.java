package com.example.openfeign.controller;

import com.alibaba.fastjson.JSON;
import com.example.openfeign.utils.ServletUtils;
import com.share.foreign.dto.NewsDTO;
import com.share.foreign.dto.UserSessionDTO;
import com.share.foreign.enums.WebSocketTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.EOFException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 前后端交互的类实现消息的接收推送
 * WebSocket
 *
 * @author cuimeng
 * @ServerEndpoint(value = "/ws/pullAlarm") 前端通过此URI和后端交互，建立连接
 */
@Slf4j
@ServerEndpoint(value = "/ws/pullAlarm")
@Component
public class WebSocket {

    /**
     * 记录当前在线连接数
     */
    private static Map<Long, UserSessionDTO> onlineUser = new ConcurrentHashMap<>();
    /**
     *  长链接 所在的ip
     */
    private static final String alarm_user_map = "alarm_user_map";
    public static RedissonClient redisClient;
    /**
     * @Description: 当网络连接建立时触发该事件
     * @Date: 7/20/22 5:05 PM
     * @Author: Mr.Cui
     * @param [session]
     * @return: void
     **/
    @OnOpen
    public void onOpen(Session session) {
        String userId = session.getQueryString();
        log.info("QueryString_{}", userId);
        String userSessionId = null;
        if (!NumberUtils.isParsable(userId)) {
            String[] sts = userId.split(",");
            // 用户的id
            userId = sts[0];
            // 用户的seesionId 信息 用来判断 用户登陆是否有效
            userSessionId = sts[1];
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        // 关闭连接移除用户
        removeSession(session);
        log.info("有一连接关闭 sessionId : {}，当前在线人数为：{} ", session.getId(), onlineUser.size());
    }

    /**
     * 收到客户端消息后调用的方法
     * 收到信息后判定该用户是否可以接警
     * 如果有返回有，如果无则返回无
     * 之后存储该 用户的session信息,用于后续给用户推送消息
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        String userId = session.getQueryString();
        String userSessionId = null;
        if (!NumberUtils.isParsable(userId)) {
            String[] sts = userId.split(",");
            userId = sts[0];
            userSessionId = sts[1];
        }
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(userSessionId)) {
            // 没有用户信息
            return;
        }

        NewsDTO info = JSON.parseObject(message, NewsDTO.class);
        info.setWsType(WebSocketTypeEnum.off.getCode());
        //判断 用户session 是否 过期
        //boolean online = userDetailService.checkSessionAvailable(userSessionId);
        /*if (online == false) {
            // 用户不在线 关闭链接
            info.setWsType(WebSocketTypeEnum.logout.getCode());
            sendMessage(info, session);
            UserSessionDTO userInfo = removeSession(session);
            log.info("用户退出登录 WebSocket_user_id_{}  OnlineUserSize_{}", userInfo, getOnlineUserSize());
            return;
        }*/
        log.info("服务端收到客户端[{}]的消息:{} WebSocket_user_id_{}", session.getId(), message, userId);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        UserSessionDTO userSession = removeSession(session);
        if (error instanceof EOFException && userSession != null) {
            log.warn("发生错误 userId:{} sessionId {} errorMsg {}", userSession.getUserId(), session.getId(), error.getMessage());
        } else if (error instanceof EOFException) {
            log.warn("发生错误sessionId {} errorMsg {}", session.getId(), error.getMessage());
        } else if (userSession != null) {
            log.error("用户id WebSocket_user_id_{} 发生错误sessionId {} errorMsg ", userSession.getUserId(), session.getId(), error);
        } else {
            log.error("发生错误sessionId {} errorMsg ", session.getId(), error);
        }
    }

    /**
     * 服务端发送消息给客户端
     *
     * @param message   发送内容
     * @param toSession 目标session
     */
    public static void sendMessage(String message, Session toSession) {
        if (!toSession.isOpen()) {
            log.info("session已经关闭 服务端给客户端 sessionId [{}]发送消息{}", toSession.getId(), message);
            return;
        }
        try {
            log.info("服务端给客户端 sessionId [{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败：{}", e);
        }
    }

    /**
     * 服务端发送消息给客户端
     *
     * @param info      发送内容
     * @param toSession 目标session
     */
    public static void sendMessage(NewsDTO info, Session toSession) {
        try {
            String message = JSON.toJSONString(info);
            log.info("服务端给客户端 sessionId [{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败：{}", e);
        }
    }

    private static UserSessionDTO removeSession(Session session) {
        Collection<UserSessionDTO> values = onlineUser.values();
        UserSessionDTO result = null;
        for (UserSessionDTO userSession : values) {
            if (userSession.getSession().equals(session)) {
                result = onlineUser.remove(userSession.getUserId());
                log.info("用户关闭连接 WebSocket_user_id_{} sessionId:{}", result.getUserId(), session.getId());
                RMap<Long, String> userMap = redisClient.getMap(alarm_user_map);
                userMap.remove(result.getUserId());
                break;
            }
        }
        return result;
    }


    public static RMap<Long, String> getUserIp() {
        RMap<Long, String> userMap = redisClient.getMap(alarm_user_map);
        return userMap;
    }


    /**
     * 添加用户
     *
     * @param session
     * @param uSession
     */
    public static void addUser(Session session, UserSessionDTO uSession) {
        WebSocket.onlineUser.put(uSession.getUserId(), uSession);
        // ip 信息
        String ip = null;
        try {
            ip = ServletUtils.getHostIp();
        } catch (IllegalStateException e) {
            // 页面快速刷新的时候，会抛出异常
            removeSession(session);
            return;
        }
        if (StringUtils.isBlank(ip)) {
            return;
        }
        log.info("localHost {}", ip);
        RMap<Long, String> userMap = redisClient.getMap(alarm_user_map);
        userMap.put(uSession.getUserId(), ip);
    }

    public static int getOnlineUserSize() {
        return onlineUser.size();
    }

    public static UserSessionDTO getUserSession(Session session) {
        Collection<UserSessionDTO> values = onlineUser.values();
        for (UserSessionDTO userSession : values) {
            if (userSession.getSession().equals(session)) {
                return userSession;
            }
        }
        return null;
    }

    public static Map<Long, UserSessionDTO> getOnlineUser() {
        return onlineUser;
    }
}