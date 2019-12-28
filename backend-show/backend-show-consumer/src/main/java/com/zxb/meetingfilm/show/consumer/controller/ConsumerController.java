package com.zxb.meetingfilm.show.consumer.controller;

import com.zxb.meetingfilm.show.consumer.service.ConsumerServiceAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 11:18
 */
@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private ConsumerServiceAPI serviceAPI;

    @RequestMapping(value = "/sayhello")
    public String sayHello(String message){

        return serviceAPI.sayHello(message);
    }
}
