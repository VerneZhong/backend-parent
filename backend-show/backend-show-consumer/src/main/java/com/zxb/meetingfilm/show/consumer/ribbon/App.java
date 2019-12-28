package com.zxb.meetingfilm.show.consumer.ribbon;

import com.netflix.client.ClientException;
import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import com.netflix.niws.client.http.RestClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 动态修改 Ribbon serverList
 *
 * @author Mr.zxb
 * @date 2019-12-28 11:23
 */
public class App {

    public static void main(String[] args) throws IOException, URISyntaxException, ClientException,
            InterruptedException {

        // 读取配置文件
        ConfigurationManager.loadPropertiesFromResources("zhongxb.properties");
        System.err.println(ConfigurationManager.getConfigInstance().getProperty("zhongxb-client.ribbon.listOfServers"));

        // 构建一个HttpClient，serverList固定的情况
        RestClient client = (RestClient) ClientFactory.getNamedClient("zhongxb-client");
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("/")).build();

        for (int i = 0; i < 5; i++)  {
            HttpResponse response = client.executeWithLoadBalancer(request);
            System.err.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus());
        }

        // 动态修改的 serverList
        ZoneAwareLoadBalancer lb = (ZoneAwareLoadBalancer) client.getLoadBalancer();
        System.err.println(lb.getLoadBalancerStats());

        ConfigurationManager.getConfigInstance().setProperty("zhongxb-client.ribbon.listOfServers", "www.qq.com:80,www.taobao.com:80");
        System.err.println("changing servers.");
        Thread.sleep(3000);

        for (int i = 0; i < 5; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            System.err.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus());
        }
        System.err.println(lb.getLoadBalancerStats());

        // 最好的情况就是Ribbon和注册中心结合使用
    }
}
