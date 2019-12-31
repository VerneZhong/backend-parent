package com.zxb.meetingfilm.show.consumer.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-31 17:43
 */
@Service
public class MyFallbackFactory implements FallbackFactory {
    @Override
    public ProviderAPI create(Throwable throwable) {
        return message -> "invokeProviderService MyFallbackFactory message=" + message;
    }
}
