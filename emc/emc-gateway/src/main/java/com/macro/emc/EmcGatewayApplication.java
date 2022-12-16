package com.macro.emc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmcGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmcGatewayApplication.class, args);
    }

}
