package com.zxb.hystrix.show.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-30 10:10
 */
public class ObserveCommandDemo extends HystrixObservableCommand<String> {

    private String name;

    public ObserveCommandDemo(String name) {
        super(HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(
                "ObserveCommandDemo")).andCommandKey(HystrixCommandKey.Factory.asKey("ObserveCommandKey")));
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        System.out.println("current thread: " + Thread.currentThread().getName());
        return Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            // 业务处理
            subscriber.onNext("action 1, name=" + name);
            subscriber.onNext("action 2, name=" + name);
            subscriber.onNext("action 3, name=" + name);

            // 业务处理结束
            subscriber.onCompleted();
        }).subscribeOn(Schedulers.io());
    }
}
