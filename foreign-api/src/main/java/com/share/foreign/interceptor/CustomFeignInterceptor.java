package com.share.foreign.interceptor;

/**
 * @ClassName CustomFeignInterceptor
 * @Description 自定义feign拦截器
 * @Author Mr.Cui
 * @Date 3/2/22 3:57 PM
 */

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * 自定义feign拦截器
 * @author Mr.Cui
 */
@Slf4j
public class CustomFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //写一些自己的业务逻辑 带上token 什么之类的
        log.info("开始执行远程调用");
        String access_token = UUID.randomUUID().toString();
        requestTemplate.header("Authorization",access_token);//设置认证
    }
}
