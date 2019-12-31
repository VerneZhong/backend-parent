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
@FeignClient(
        // 与Ribbon整合，name的值就是对应注册在Eureka上服务名称
        name = "hello-service-provider",
//        primary = true,
//        configuration = FeignHelloConfig.class,
        // 与Hystrix整合，降级访问
//        fallback = DefaultProviderFallbackAPI.class,
        fallbackFactory = MyFallbackFactory.class,
        path = "/provider"
//        url = "http://localhost:7101/"
)
public interface ProviderAPI {


    @RequestMapping(value = "/sayhello")
    String invokeProviderService(@RequestParam("message") String message);

    /**
     * 上面的案例用的是默认SpringMvcContract方式，可以直接使用SpringMvc注解
     * 自定义的Contract，使用Feign的声明方式
     *
     */
//    @RequestLine("GET /sayhello?message={message}")
//    String invokeProviderService(@Param("message") String message);

//    @RequestMapping(value = "/{providerId}/sayhello", method = RequestMethod.POST)
//    String prividerPost(
//            @RequestHeader("author") String author,
//            @PathVariable("providerId") String providerId,
//            @RequestBody UserModel userModel);
}
