package com.example.openfeign.configuration;

/**
 * WebSocket 配置和 向类中注入依赖
 *
 * @author cuimeng
 */
//@Configuration
public class WebSocketConfig {

    /**
     * 注入一个ServerEndpointExporter,该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint
     */
    /*@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }*/


    /**
     * 向 WebSocket 中注入对象
     */

    /*@Autowired
    public void setUserService(RedissonClient redisClient) {
        WebSocket.redisClient = redisClient;
    }
    */

}