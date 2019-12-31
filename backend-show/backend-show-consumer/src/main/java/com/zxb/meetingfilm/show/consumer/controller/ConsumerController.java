package com.zxb.meetingfilm.show.consumer.controller;

import com.zxb.meetingfilm.show.consumer.feign.ProviderAPI;
import com.zxb.meetingfilm.show.consumer.feign.vo.UserModel;
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

    @Autowired
    private ProviderAPI providerAPI;

    @RequestMapping(value = "/sayhello")
    public String sayHello(String message){
        return serviceAPI.sayHello(message);
    }

    @RequestMapping(value = "/feign/sayhello")
    public String sayHelloFeign(String message){
        System.out.println("feign message = " + message);
        return providerAPI.invokeProviderService(message);
    }

//    @RequestMapping(value = "/feign/post/sayhello")
//    public String sayHelloPost(String author, String providerId, UserModel userModel) {
//        log.info("author: {}, providerId: {}, userModel: {}", author, providerId, userModel);
//        return providerAPI.prividerPost(author, providerId, userModel);
//    }
}
