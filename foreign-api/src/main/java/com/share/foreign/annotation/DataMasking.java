package com.share.foreign.annotation;

import com.share.foreign.enums.systemEnums.DataMaskingFunc;

import java.lang.annotation.*;

/**
 * 返回数据脱敏
 * @author cuimeng
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {
    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;
}
