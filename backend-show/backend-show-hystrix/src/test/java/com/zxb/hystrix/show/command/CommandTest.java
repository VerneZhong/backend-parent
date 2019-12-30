package com.zxb.hystrix.show.command;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 18:34
 */
public class CommandTest {

    @Test
    public void testExecute() {
        long startTime = System.currentTimeMillis();
        CommandHystrixDemo commandHystrixDemo = new CommandHystrixDemo("execute");

        // 同步执行 Command execute
        String execute = commandHystrixDemo.execute();

        long endTime = System.currentTimeMillis();
        System.out.println("execute = " + execute + ", cost = " + (endTime - startTime) + "ms");
    }

    @Test
    public void testQueue() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CommandHystrixDemo commandHystrixDemo = new CommandHystrixDemo("queue");

        // 异步执行 Command queue
        Future<String> future = commandHystrixDemo.queue();

        long endTime = System.currentTimeMillis();
        System.out.println("future end cost = " + (endTime - startTime) + "ms");

        String result = future.get();
        long endTime2 = System.currentTimeMillis();
        System.out.println("queue = " + result + ", cost = " + (endTime2 - startTime) + "ms");
    }

    @Test
    public void testObserver() {
        long startTime = System.currentTimeMillis();
        CommandHystrixDemo commandHystrixDemo = new CommandHystrixDemo("observe");

        // 阻塞式调用 Command observe
        Observable<String> observe = commandHystrixDemo.observe();

        String single = observe.toBlocking().single();

        long endTime = System.currentTimeMillis();
        System.out.println("observe = " + single + ", cost = " + (endTime - startTime) + "ms");
    }

    @Test
    public void testSubscribe() {
        long startTime = System.currentTimeMillis();
        CommandHystrixDemo commandHystrixDemo = new CommandHystrixDemo("subscribe");

        // 阻塞式调用 Command observe
        Observable<String> observe = commandHystrixDemo.observe();

        String single = observe.toBlocking().single();
        System.out.println("observe = " + single + ", cost = " + (System.currentTimeMillis() - startTime) + "ms");

        // 订阅式调用 Command subscribe
        observe.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("observer onCompleted.");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("observer onError :" + throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("observer onNext result = " + s);
                long endTime = System.currentTimeMillis();
                System.out.println("testSubscribe, cost = " + (endTime - startTime) + "ms");
            }
        });
    }

    @Test
    public void testToObservable() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CommandHystrixDemo commandHystrixDemo = new CommandHystrixDemo("toObservable");

        // 阻塞式调用 Command observe
        Observable<String> observe = commandHystrixDemo.toObservable();

        String single = observe.toBlocking().single();
        System.out.println("toObservable = " + single + ", cost = " + (System.currentTimeMillis() - startTime) + "ms");

        // 订阅式调用 Command subscribe
        CommandHystrixDemo commandHystrixDemo2 = new CommandHystrixDemo("toObservable2");
        commandHystrixDemo2.toObservable().subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("toObservable2 onCompleted.");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("toObservable2 onError :" + throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("toObservable2 onNext result = " + s);
                System.out.println("toObservable2, cost = " + (System.currentTimeMillis() - startTime) + "ms");
            }
        });

        Thread.sleep(2000L);
    }

    @Test
    public void testRequestCache() {
        // 开启请求上下文
        HystrixRequestContext requestContext = HystrixRequestContext.initializeContext();

        long startTime = System.currentTimeMillis();

        CommandHystrixDemo c1 = new CommandHystrixDemo("c1");
        CommandHystrixDemo c2 = new CommandHystrixDemo("c2");
        CommandHystrixDemo c3 = new CommandHystrixDemo("c1");

        // 第一次请求
        String e1 = c1.execute();
        System.out.println("execute = " + e1 + ", cost = " + (System.currentTimeMillis() - startTime) + "ms");

        // 第二次请求
        String e2 = c2.execute();
        System.out.println("execute = " + e2 + ", cost = " + (System.currentTimeMillis() - startTime) + "ms");

        // 第三次请求
        String e3 = c3.execute();
        System.out.println("execute = " + e3 + ", cost = " + (System.currentTimeMillis() - startTime) + "ms");

        // 请求上下文关闭
        requestContext.close();
    }

    @Test
    public void testThreadPool() throws ExecutionException, InterruptedException {
        // 演示线程池配置
        CommandHystrixDemo c1 = new CommandHystrixDemo("c1");
        CommandHystrixDemo c2 = new CommandHystrixDemo("c2");
        CommandHystrixDemo c3 = new CommandHystrixDemo("c3");
        CommandHystrixDemo c4 = new CommandHystrixDemo("c4");
        CommandHystrixDemo c5 = new CommandHystrixDemo("c5");

        Future<String> q1 = c1.queue();
        Future<String> q2 = c2.queue();
        Future<String> q3 = c3.queue();
        Future<String> q4 = c4.queue();
        Future<String> q5 = c5.queue();

        String s1 = q1.get();
        String s2 = q2.get();
        String s3 = q3.get();
        String s4 = q4.get();
        String s5 = q5.get();

        System.out.println(s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5);
    }

    @Test
    public void testSemaphore() throws InterruptedException {
        // 演示信号量
        new MyThread("t1").start();
        new MyThread("t2").start();
        new MyThread("t3").start();
        new MyThread("t4").start();
        new MyThread("t5").start();

        Thread.sleep(2000L);

    }

    class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            CommandHystrixDemo commandHystrixDemo = new CommandHystrixDemo(name);
            System.out.println("CommandHystrixDemo result = " + commandHystrixDemo.execute());
        }
    }
}
