package com.example.openfeign.handler;

import com.example.openfeign.exception.BaseException;
import com.example.openfeign.enums.systemEnums.ErrorCode;
import com.example.openfeign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName WebExceptionHandler
 * @Description controller 统一异常处理
 * @Author Mr.Cui
 * @Date 4/28/22 3:34 PM
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class WebExceptionHandler {

    public WebExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    public ResponseTemplate unknownException(Exception e) {
        if (e instanceof BaseException) {
            ResponseTemplate result = new ResponseTemplate();
            BaseException base = (BaseException)e;
            result.setErrno(base.getErrno().getCode());
            result.setErrmsg(base.getErrmsg() == null ? base.getErrno().getChineseDes() : base.getErrmsg());
            log.info("msg :{}", e);
            return result;
        } else {
            log.error("发生了未知异常", e);
            return ResponseTemplate.buildFailResult(ErrorCode.FAILED_REQUEST);
        }
    }
}