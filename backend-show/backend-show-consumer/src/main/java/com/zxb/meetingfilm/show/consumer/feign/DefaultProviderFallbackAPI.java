package com.zxb.meetingfilm.show.consumer.feign;

import org.springframework.stereotype.Service;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-31 17:05
 */
@Service
public class DefaultProviderFallbackAPI implements ProviderAPI {

    @Override
    public String invokeProviderService(String message) {
        return "invokeProviderService fallback message=" + message;
    }
}
