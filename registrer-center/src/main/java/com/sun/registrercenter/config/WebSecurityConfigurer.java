package com.sun.registrercenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zcm
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();     //关闭跨域
        http.authorizeRequests()   //认证请求
                .anyRequest()      //对任何请求
                .authenticated()   //都需要认证
                .and()
                .httpBasic()      //使用Spring Security提供的登录界面
                .and()
                .formLogin();
    }
}
