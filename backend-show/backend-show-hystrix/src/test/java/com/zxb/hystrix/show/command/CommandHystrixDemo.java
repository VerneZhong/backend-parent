package com.zxb.hystrix.show.command;

import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Hystrix特性演示
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
                                .withExecutionIsolationSemaphoreMaxConcurrentRequests(3)
                                .withFallbackIsolationSemaphoreMaxConcurrentRequests(2)
//                                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                                // 超时检测是否开启
//                                .withExecutionTimeoutEnabled(false)
                                // 强制开启熔断器
//                                .withCircuitBreakerForceOpen(true)
                                // 单位时间内的请求阈值
                                .withCircuitBreakerRequestVolumeThreshold(2)
                                // 当满足请求阈值时，超过50%则开启熔断
                                .withCircuitBreakerErrorThresholdPercentage(50)

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

    /**
     * 降级方法
     * @return
     */
    @Override
    protected String getFallback() {
        String result = "Fallback name: " + name;

        log.info(result + ", currentThread-" + Thread.currentThread().getName());

        return result;
    }

    @Override
    protected String run() throws Exception {

        String result = "CommandHystrixDemo run name: " + name;

        log.info(result + ", currentThread-" + Thread.currentThread().getName());

        Thread.sleep(800l);

        if (name.endsWith("error")) {
            int i = 1 / 0;
        }

        return result;
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(name);
    }
}
