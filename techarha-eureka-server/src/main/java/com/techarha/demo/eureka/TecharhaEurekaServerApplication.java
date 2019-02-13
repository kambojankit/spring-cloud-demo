package com.techarha.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TecharhaEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TecharhaEurekaServerApplication.class, args);
    }

}

