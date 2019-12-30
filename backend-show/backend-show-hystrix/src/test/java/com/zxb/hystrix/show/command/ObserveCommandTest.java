package com.zxb.hystrix.show.command;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-30 10:42
 */
public class ObserveCommandTest {

    @Test
    public void testSubscribe() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ObserveCommandDemo commandHystrixDemo = new ObserveCommandDemo("ObserveCommandTest - subscribe");

        // 阻塞式调用 Command observe
        Observable<String> observe = commandHystrixDemo.observe();
//
//        String single = observe.toBlocking().single();
//        System.out.println("ObserveCommandTest -observe = " + single + ", cost = " + (System.currentTimeMillis() - startTime) + "ms");

        // 订阅式调用 Command subscribe
        observe.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("ObserveCommandTest -observer onCompleted.");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("ObserveCommandTest -observer onError :" + throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("ObserveCommandTest -observer onNext result = " + s);
                long endTime = System.currentTimeMillis();
                System.out.println("testSubscribe, cost = " + (endTime - startTime) + "ms");
            }
        });

        Thread.sleep(2000);
    }
}
