package com.sun.myclientcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zcm
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MyclientCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyclientCenterApplication.class, args);
    }

}
