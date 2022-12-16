package com.macro.emc.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.macro.emc")
public class EmcAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmcAuthApplication.class, args);
    }

}
