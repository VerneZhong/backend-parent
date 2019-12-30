package com.zxb.hystrix.show.command;

import com.netflix.hystrix.*;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 请求合并处理对象
 *
 * @author Mr.zxb
 * @date 2019-12-30 14:03
 */
public class CommandCollasper extends HystrixCollapser<List<String>, String, Integer> {

    private Integer id;

    public CommandCollasper(Integer id) {
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("CommandCollasper"))
                .andCollapserPropertiesDefaults(
                        HystrixCollapserProperties.defaultSetter().withTimerDelayInMilliseconds(1000)
                ));
        this.id = id;
    }

    /**
     * 获取请求参数
     *
     * @return
     */
    @Override
    public Integer getRequestArgument() {
        return id;
    }

    /**
     * 创建Command
     *
     * @param collapsedRequests
     * @return
     */
    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, Integer>> collapsedRequests) {
        return new BatchCommand(collapsedRequests);
    }

    /**
     * 批量处理结果与请求业务之间映射关系处理
     *
     * @param batchResponse
     * @param collapsedRequests
     */
    @Override
    protected void mapResponseToRequests(List<String> batchResponse,
                                         Collection<CollapsedRequest<String, Integer>> collapsedRequests) {
        int count = 0;
        Iterator<CollapsedRequest<String, Integer>> iterator = collapsedRequests.iterator();
        while (iterator.hasNext()) {
            CollapsedRequest<String, Integer> next = iterator.next();

            String s = batchResponse.get(count++);

            next.setResponse(s);
        }
    }

    public static class BatchCommand extends HystrixCommand<List<String>> {

        private Collection<CollapsedRequest<String, Integer>> collapsedRequests;

        protected BatchCommand(Collection<CollapsedRequest<String, Integer>> collapsedRequests) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("BatchCommand")));
            this.collapsedRequests = collapsedRequests;
        }

        @Override
        protected List<String> run() throws Exception {
            System.out.println("currentThread: " + Thread.currentThread().getName());
            ArrayList<String> result = Lists.newArrayList();

            Iterator<CollapsedRequest<String, Integer>> iterator = collapsedRequests.iterator();
            while (iterator.hasNext()) {
                CollapsedRequest<String, Integer> next = iterator.next();

                Integer argument = next.getArgument();

                // 具体业务逻辑
                result.add("Mooc req: " + argument);
            }

            return result;
        }
    }

}
