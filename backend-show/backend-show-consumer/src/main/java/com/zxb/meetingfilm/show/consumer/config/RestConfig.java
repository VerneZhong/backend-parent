package com.zxb.meetingfilm.show.consumer.config;

import com.netflix.loadbalancer.*;
import com.netflix.niws.loadbalancer.NIWSDiscoveryPing;
import com.zxb.meetingfilm.show.consumer.ribbon.rules.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 16:26
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 负载均衡规则
     * @return
     */
    @Bean
    public IRule iRule() {
        // 随机
//        return new RandomRule();

        // 轮询
        return new RoundRobinRule();

        // 自定义 rule
//        return new MyRule();
    }

    /**
     * 服务健康检测规则
     * @return
     */
    @Bean
    public IPing iPing() {
        // 配置自定义 url，心跳检测
//        return new PingUrl(false, "/abc");

        // 依赖eureka，根据eureka上的服务健康状态来选择
        return new NIWSDiscoveryPing();
    }
}
