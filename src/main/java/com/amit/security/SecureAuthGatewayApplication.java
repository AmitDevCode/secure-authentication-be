package com.amit.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(scanBasePackages = "com.amit.security")
public class SecureAuthGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureAuthGatewayApplication.class, args);
    }

}
