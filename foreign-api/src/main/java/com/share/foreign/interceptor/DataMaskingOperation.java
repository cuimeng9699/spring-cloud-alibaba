package com.share.foreign.interceptor;

/**
 * @author cuimeng
 */
public interface DataMaskingOperation {
    String MASK_CHAR = "*";

    String mask(String content, String maskChar);
}
