package com.zxb.meetingfilm.user;

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
@MapperScan(basePackages = "com.zxb.meetingfilm.user.dao.mapper")
public class BackendUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendUserApplication.class, args);
    }
}
