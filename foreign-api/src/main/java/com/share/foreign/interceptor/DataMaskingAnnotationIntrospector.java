package com.share.foreign.interceptor;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.share.foreign.annotation.DataMasking;

/**
 * @ClassName DataMaskingAnnotationIntrospector
 * @Description 自定义 AnnotationIntrospector，适配我们自定义注解返回相应的 Serializer
 * @Author Mr.Cui
 * @Date 7/18/22 1:52 PM
 */
public class DataMaskingAnnotationIntrospector extends NopAnnotationIntrospector {
    @Override
    public Object findSerializer(Annotated am) {
        DataMasking annotation = am.getAnnotation(DataMasking.class);
        if (annotation != null) {
            return new DataMaskingSerializer(annotation.maskFunc().operation());
        }
        return null;
    }
}
