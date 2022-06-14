package com.example.servicenacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNacosApplication.class, args);
    }

}
