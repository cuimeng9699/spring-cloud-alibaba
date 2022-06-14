package com.example.openfeign.exception;

import com.example.openfeign.enums.systemEnums.ErrorCode;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author Mr.Cui
 * @Date 4/28/22 3:40 PM
 */
public class BaseException extends RuntimeException {
    private ErrorCode errno;
    private String errmsg;

    public BaseException() {
        super(ErrorCode.FAILED_REQUEST.getChineseDes());
        this.errno = ErrorCode.FAILED_REQUEST;
    }

    public BaseException(ErrorCode errorInfo) {
        super(errorInfo.getChineseDes());
        this.errno = errorInfo;
    }

    public BaseException(String errmsg) {
        super(errmsg);
        this.errno = ErrorCode.FAILED_REQUEST;
        this.errmsg = errmsg;
    }

    public BaseException(ErrorCode errorInfo, String extraMessage) {
        super(extraMessage);
        this.errno = errorInfo;
        this.errmsg = extraMessage;
    }

    public ErrorCode getErrno() {
        return this.errno;
    }

    public void setErrno(ErrorCode errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
