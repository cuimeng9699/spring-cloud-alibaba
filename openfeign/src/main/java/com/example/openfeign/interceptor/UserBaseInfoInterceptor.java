package com.example.openfeign.interceptor;

import com.example.openfeign.utils.UserContext;
import com.share.foreign.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author Mr.Cui
 */
@Slf4j
public class UserBaseInfoInterceptor implements HandlerInterceptor {

    public UserBaseInfoInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            log.info("path:{}",request.getRequestURI());
            UserContext.clear();
            String userIdString = request.getHeader("userId");

            if (StringUtils.isNotBlank(userIdString)) {
                long start = System.currentTimeMillis();


            }
            UserDTO user = UserDTO.builder()
                    .id(1)
                    .birthday(new Date())
                    .name("cuimeng")
                    .address("北京")
                    .build();
            UserContext.setCurrentUser(user);

            return true;
        }
    }
}
