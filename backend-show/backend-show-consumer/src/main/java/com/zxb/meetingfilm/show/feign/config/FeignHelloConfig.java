package com.zxb.meetingfilm.show.feign.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-31 15:52
 */
@Configuration
public class FeignHelloConfig {

    @Bean
    public Contract contract() {
        return new feign.Contract.Default();
    }
}
