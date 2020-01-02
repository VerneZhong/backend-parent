package com.zxb.meetingfilm.film;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 11:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.zxb.meetingfilm")
@MapperScan(basePackages = "com.zxb.meetingfilm.film.dao.mapper")
public class FilmApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilmApplication.class, args);
    }
}
