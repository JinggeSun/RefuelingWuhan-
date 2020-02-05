package com.sun.zuulcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zcm
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulCenterApplication.class, args);
    }

}
