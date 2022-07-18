package com.share.foreign.configuration;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.share.foreign.interceptor.DataMaskingAnnotationIntrospector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @ClassName DataMaskConfiguration
 * @Description 覆盖 ObjectMapper
 * @Author Mr.Cui
 * @Date 7/18/22 1:56 PM
 */
@Configuration(
        proxyBeanMethods = false
)
public class DataMaskConfiguration {
    @Configuration(
            proxyBeanMethods = false
    )
    @ConditionalOnClass({Jackson2ObjectMapperBuilder.class})
    static class JacksonObjectMapperConfiguration {
        JacksonObjectMapperConfiguration() {
        }

        @Bean
        @Primary
        ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
            ObjectMapper objectMapper = builder.createXmlMapper(false).build();
            AnnotationIntrospector ai = objectMapper.getSerializationConfig().getAnnotationIntrospector();
            AnnotationIntrospector newAi = AnnotationIntrospectorPair.pair(ai, new DataMaskingAnnotationIntrospector());
            objectMapper.setAnnotationIntrospector(newAi);
            return objectMapper;
        }
    }

}
