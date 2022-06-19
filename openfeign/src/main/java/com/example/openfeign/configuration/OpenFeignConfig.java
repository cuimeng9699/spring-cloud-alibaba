package com.example.openfeign.configuration;

import com.share.foreign.interceptor.CustomFeignInterceptor;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局配置：当使用@Configuration 会将配置作用所有的服务提供方
 * 局部配置：如果只想针对某一个服务进行配置，就不要加@Configuration
 */
/**
 * 全局配置：当使用@Configuration 会将配置作用所有的服务提供方
 * 局部配置：1、如果只想针对某一个服务进行配置，就不要加@Configuration
 *         2、配置文件
 */
@Configuration
public class OpenFeignConfig {

    /**
     * 日志配置
     * @return
     */
    @Bean
     public Logger.Level feignLoggerLevel(){
         return Logger.Level.FULL;
     }


    @Bean
    public CustomFeignInterceptor customFeignInterceptor() {
        return new CustomFeignInterceptor();
    }
}
