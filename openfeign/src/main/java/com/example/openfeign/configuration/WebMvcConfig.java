package com.example.openfeign.configuration;

import com.example.openfeign.interceptor.UserBaseInfoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public UserBaseInfoInterceptor getUserInfoInterceptor() {
        return new UserBaseInfoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(getUserInfoInterceptor()).order(1);
        registration.addPathPatterns("/**");

        //不需要拦截的url
        registration.excludePathPatterns(
                ""
        );
    }

}
