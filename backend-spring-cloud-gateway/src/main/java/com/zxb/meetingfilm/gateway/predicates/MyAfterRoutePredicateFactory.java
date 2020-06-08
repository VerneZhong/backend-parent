package com.zxb.meetingfilm.gateway.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.function.Predicate;

/**
 * 用于承载断言所需的参数
 *
 * @author Mr.zxb
 * @date 2020-01-20 17:49
 */
public class MyAfterRoutePredicateFactory extends AbstractRoutePredicateFactory<MyAfterRoutePredicateFactory.Config> {



    public MyAfterRoutePredicateFactory(Class<Config> configClass) {
        super(configClass);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return null;
    }

    public static class Config {
        @NotEmpty
        private String dateTime;

        public Config() {
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }
    }
}
