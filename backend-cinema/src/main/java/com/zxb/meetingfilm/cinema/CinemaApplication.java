package com.zxb.meetingfilm.cinema;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 16:27
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.zxb.meetingfilm")
@MapperScan(basePackages = "com.zxb.meetingfilm.cinema.dao.mapper")
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }
}
