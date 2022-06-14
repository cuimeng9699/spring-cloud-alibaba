package com.example.servicenacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.servicenacosconfig.interfance")
@EnableAsync
public class ServiceNacosconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNacosconfigApplication.class, args);
    }


}
