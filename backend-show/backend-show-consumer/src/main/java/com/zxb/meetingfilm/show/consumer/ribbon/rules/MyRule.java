package com.zxb.meetingfilm.show.consumer.ribbon.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡规则
 *
 * @author Mr.zxb
 * @date 2019-12-28 17:29
 */
public class MyRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {

        // 灰度发布 10% 的流量在新的功能， ～ 90% 的流量在旧功能
        // 对 10% 有没有限制，已经访问过新功能的流量不能再访问旧的功能

        // 定义一个新功能的 ServerList
        // up all

        // 每次请求进入，判断对应的客户端是不是已经访问过新的 ServerList
            // 如果是，则直接访问新的 ServerList
            // 如果不是，则继续后续判断

        // 引入缓存，十个请求里随机取2～3个请求进入新的功能的 ServerList

        Server server = getLoadBalancer().getAllServers().get(0);

        return server;
    }
}
