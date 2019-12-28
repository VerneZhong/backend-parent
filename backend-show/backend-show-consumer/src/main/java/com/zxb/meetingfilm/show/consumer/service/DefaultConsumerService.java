package com.zxb.meetingfilm.show.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 11:21
 */
@Service
public class DefaultConsumerService implements ConsumerServiceAPI {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Override
    public String sayHello(String message) {
        String uri = "/provider/sayhello?message="+message;

        // http://localhost:7101/provider/sayhello?message=hello
        String url = "http://hello-service-provider"+uri;

//        ServiceInstance choose = loadBalancerClient.choose("hello-service-provider");
//        String url = "http://" + choose.getHost() + ":" + choose.getPort() + uri;

        // invoker provider test
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }
}
