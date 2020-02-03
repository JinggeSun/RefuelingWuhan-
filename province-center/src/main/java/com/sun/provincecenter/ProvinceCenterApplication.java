package com.sun.provincecenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 省份中心
 * @author zcm
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sun.provincecenter.mapper")
public class ProvinceCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvinceCenterApplication.class, args);
    }

}
