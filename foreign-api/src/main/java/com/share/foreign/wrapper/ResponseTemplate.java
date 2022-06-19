package com.share.foreign.wrapper;

import com.share.foreign.enums.systemEnums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName ResponseTemplate
 * @Description 返回模板
 * @Author cuimeng
 * @Date 4/28/22 3:36 PM
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseTemplate<T> {
    private Integer errno;
    private String errmsg;
    private T data;

    public Integer getErrno() {
        return this.errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void SetEnumCode(ErrorCode code) {
        this.errno = code.getCode();
        this.errmsg = code.getChineseDes();
    }

    public ResponseTemplate() {
        this.errno = ErrorCode.SUCCESS_REQUEST.getCode();
        this.errmsg = ErrorCode.SUCCESS_REQUEST.getChineseDes();
    }

    public ResponseTemplate(Integer errno, String errmsg, T data) {
        this.errno = ErrorCode.SUCCESS_REQUEST.getCode();
        this.errmsg = ErrorCode.SUCCESS_REQUEST.getChineseDes();
        this.errno = errno;
        this.errmsg = errmsg;
        this.data = data;
    }

    public ResponseTemplate(ErrorCode errno, T data) {
        this.errno = ErrorCode.SUCCESS_REQUEST.getCode();
        this.errmsg = ErrorCode.SUCCESS_REQUEST.getChineseDes();
        this.errno = errno.getCode();
        this.errmsg = errno.getChineseDes();
        this.data = data;
    }

    public static ResponseTemplate buildSuccessResult() {
        return new ResponseTemplate(ErrorCode.SUCCESS_REQUEST, (Object) null);
    }

    public static <U> ResponseTemplate<U> buildSuccessResult(U data) {
        return new ResponseTemplate(ErrorCode.SUCCESS_REQUEST, data);
    }

    public static ResponseTemplate buildFailResult(ErrorCode errorCode) {
        return new ResponseTemplate(errorCode.getCode(), errorCode.getDes(), (Object) null);
    }

    public static <U> ResponseTemplate<U> buildFailResult(Integer errno, String msg, U data) {
        return new ResponseTemplate(errno, msg, data);
    }

    public static <U> ResponseTemplate<U> of(ErrorCode error) {
        return new ResponseTemplate(error.getCode(), error.getChineseDes(), (Object) null);
    }

    public static <U> ResponseTemplate<U> of() {
        return new ResponseTemplate(0, "", (Object) null);
    }

    public static <U> ResponseTemplate<U> buildResult(ErrorCode error, U data) {
        return new ResponseTemplate(error.getCode(), error.getChineseDes(), data);
    }

    public static ResponseTemplate buildResponseWithBindingErrors(BindingResult bindingResult) {
        Map<String, String> errmsg = new HashMap();
        Iterator var2 = bindingResult.getFieldErrors().iterator();

        while (var2.hasNext()) {
            FieldError error = (FieldError) var2.next();
            errmsg.put(error.getField(), error.getDefaultMessage());
        }

        return buildResult(ErrorCode.PARAM_ERROR, errmsg);
    }
}
