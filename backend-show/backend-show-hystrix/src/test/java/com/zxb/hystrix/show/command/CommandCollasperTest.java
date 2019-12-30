package com.zxb.hystrix.show.command;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-30 14:16
 */
public class CommandCollasperTest {

    @Test
    public void testCollasper() throws ExecutionException, InterruptedException {
        // 初始化上下文
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();

        // 构建请求 -> 主要优化点，多个服务调用的多次HTTP请求合并
        // 缺点：很少有机会对同一个服务进行多次HTTP调用，同时还要足够的"近"
        CommandCollasper c1 = new CommandCollasper(1);
        CommandCollasper c2 = new CommandCollasper(2);
        CommandCollasper c3 = new CommandCollasper(3);
        CommandCollasper c4 = new CommandCollasper(4);

        // 获取结果
        Future<String> q1 = c1.queue();
//        Thread.sleep(500L);
        Future<String> q2 = c2.queue();
//        Thread.sleep(500L);
        Future<String> q3 = c3.queue();
//        Thread.sleep(500L);
        Future<String> q4 = c4.queue();

        String r1 = q1.get();
        String r2 = q2.get();
        String r3 = q3.get();
        String r4 = q4.get();

        System.out.println(r1 + ", " + r2 + ", " + r3 + ", " + r4);

        // 关闭上下文
        hystrixRequestContext.close();
    }
}
