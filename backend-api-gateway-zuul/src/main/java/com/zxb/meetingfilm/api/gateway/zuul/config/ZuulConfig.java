package com.zxb.meetingfilm.api.gateway.zuul.config;

import com.zxb.meetingfilm.api.gateway.zuul.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-01 17:46
 */
@Configuration
public class ZuulConfig {

    @Bean
    public MyFilter initMyFilter() {
        return new MyFilter();
    }
}
