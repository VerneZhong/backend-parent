package com.zxb.hystrix.show.command;

import com.netflix.hystrix.*;
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
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandHelloWorld"))
                .andCommandPropertiesDefaults(
                        // 请求缓存开关，关闭
                        HystrixCommandProperties.defaultSetter().withRequestCacheEnabled(false)
                                // 线程池隔离策略，使用信号量隔离或是线程池隔离
                                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                                .withExecutionIsolationSemaphoreMaxConcurrentRequests(5)
                                .withFallbackIsolationSemaphoreMaxConcurrentRequests(2)
//                                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                                // 超时检测是否开启
//                                .withExecutionTimeoutEnabled(false)


                )
                // 设置线程池线程名称
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("zxb-thread-pool"))
                // 线程池属性配置
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.defaultSetter()
                                // 核心线程数
                                .withCoreSize(2)
                                // 最大线程数
                                .withMaximumSize(3)
                                // 允许开启最大线程数
                                .withAllowMaximumSizeToDivergeFromCoreSize(true)
                                // 队列最大容量
                                .withMaxQueueSize(2)

                )
        );
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
