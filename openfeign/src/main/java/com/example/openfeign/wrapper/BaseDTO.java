package com.example.openfeign.wrapper;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName BaseDTO
 * @Description 请求头
 * @Author cuimeng
 * @Date 6/9/22 10:01 AM
 */
@Data
public class BaseDTO<T> {

    @Valid
    @NotNull(message = "消息体[body]不能为空")
    private T body;

}
