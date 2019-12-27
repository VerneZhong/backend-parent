package com.zxb.meetingfilm.film;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 16:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.zxb.meetingfilm")
@MapperScan(basePackages = "com.zxb.meetingfilm.film.dao.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
