package com.macro.emc.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmcSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmcSearchApplication.class, args);
    }
}
