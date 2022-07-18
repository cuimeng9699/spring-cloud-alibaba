package com.example.openfeign.interceptor;

import com.example.openfeign.dao.mapper.extend.UserExtMapper;
import com.example.openfeign.dao.po.User;
import com.example.openfeign.utils.UserContext;
import com.share.foreign.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Objects;

/** @author Mr.Cui */
@Slf4j
public class UserBaseInfoInterceptor implements HandlerInterceptor {

  @Resource private UserExtMapper userExtMapper;

  public UserBaseInfoInterceptor() {}

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (!(handler instanceof HandlerMethod)) {
      return true;
    } else {
      log.info("path:{}", request.getRequestURI());
      UserContext.clear();
      String userIdString = request.getHeader("userId");
      UserDTO userDTO = new UserDTO();
      if (StringUtils.isNotBlank(userIdString)) {
        long start = System.currentTimeMillis();
        User user = userExtMapper.selectByPrimaryKey(Integer.valueOf(userIdString));
        if (Objects.nonNull(user)) {
          BeanUtils.copyProperties(user, userDTO);
        }else {
          userDTO.setId(1);
          userDTO.setName("user");
          userDTO.setBirthday(new Date());
          userDTO.setAddress("北京");
        }
      } else {
        userDTO.setId(1);
        userDTO.setName("user");
        userDTO.setBirthday(new Date());
        userDTO.setAddress("北京");
      }
      UserContext.setCurrentUser(userDTO);
      return true;
    }
  }
}
