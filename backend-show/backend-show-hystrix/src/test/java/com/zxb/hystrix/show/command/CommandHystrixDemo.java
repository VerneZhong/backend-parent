package com.zxb.hystrix.show.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 18:30
 */
@Slf4j
public class CommandHystrixDemo extends HystrixCommand<String> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommandHystrixDemo(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandHelloWorld")).andCommandPropertiesDefaults(
                // 请求缓存开关，关闭
                HystrixCommandProperties.defaultSetter().withRequestCacheEnabled(false)
        ));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {

        String result = "CommandHelloWorld name: " + name;

        log.info(result + ", currentThread-" + Thread.currentThread().getName());

        Thread.sleep(800l);
        return result;
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(name);
    }
}
