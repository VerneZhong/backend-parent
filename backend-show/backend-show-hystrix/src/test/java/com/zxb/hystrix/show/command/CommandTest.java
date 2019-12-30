package com.zxb.hystrix.show.command;

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

}
