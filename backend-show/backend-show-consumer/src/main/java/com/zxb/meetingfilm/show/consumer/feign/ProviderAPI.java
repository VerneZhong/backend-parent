package com.zxb.meetingfilm.show.consumer.feign;

import com.zxb.meetingfilm.show.consumer.feign.vo.UserModel;
import com.zxb.meetingfilm.show.feign.config.FeignHelloConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * interface
 *
 * @author Mr.zxb
 * @date 2019-12-31 14:04
 */
@FeignClient(name = "providerTest",
        primary = true,
        path = "/provider",
        configuration = FeignHelloConfig.class,
        url = "http://localhost:7101/")
public interface ProviderAPI {

//    @RequestMapping(value = "/sayhello")
//    String invokeProviderService(@RequestParam("message") String message);

    @RequestLine("GET /sayhello?message={message}")
    String invokeProviderService(@Param("message") String message);

//    @RequestMapping(value = "/{providerId}/sayhello", method = RequestMethod.POST)
//    String prividerPost(
//            @RequestHeader("author") String author,
//            @PathVariable("providerId") String providerId,
//            @RequestBody UserModel userModel);
}
