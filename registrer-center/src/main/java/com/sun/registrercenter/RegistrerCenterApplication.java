package com.sun.registrercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心启动类
 * @author zcm
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrerCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrerCenterApplication.class, args);
    }

}
