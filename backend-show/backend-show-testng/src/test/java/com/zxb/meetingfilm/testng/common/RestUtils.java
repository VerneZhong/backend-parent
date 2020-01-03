package com.zxb.meetingfilm.testng.common;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-02 15:29
 */
public class RestUtils {

    private static RestTemplate restTemplate;

    public static RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }
        return restTemplate;
    }
}
