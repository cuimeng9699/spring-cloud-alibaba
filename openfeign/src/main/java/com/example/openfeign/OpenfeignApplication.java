package com.example.openfeign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Mr.Cui
 */
@Slf4j
@SpringCloudApplication
@EnableScheduling
@EnableAsync
@EnableFeignClients(basePackages = "com.share.foreign.api")
public class OpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignApplication.class, args);
        log.info("[openfeign启动成功]");
    }


}
