package com.zxb.meetingfilm.show.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 11:14
 */
@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/provider/sayhello")
    public String providerSayHello(String message) {

        log.info("provder sayhello port:{}, message:{}", port, message);

        return "Provider sayhello port:" + port + " , message:" + message;
    }

    @RequestMapping(value = "/provider/{providerId}/sayhello", method = RequestMethod.POST)
    public String postTest(
            @RequestHeader("author") String author,
            @PathVariable("providerId") String providerId,
            @RequestBody String json) {

        log.info("provder sayhello port:{},author:{} , providerId:{}, message:{}", port, author, providerId, json);

        return "Provider sayhello port:" + port + " , message:" + json;
    }
}
