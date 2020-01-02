package com.zxb.meetingfilm.api.gateway.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletResponse;

/**
 * 跨域资源共享问题
 *
 * @author Mr.zxb
 * @date 2020-01-02 13:47
 */
public class CorsFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        // 跨域
        HttpServletResponse response = ctx.getResponse();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");
        response.setHeader("Access-Control-Allow-Headers","DNT,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Range,Authorization");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        /*
            跨域资源共享
                - 这是HTTP协议规定的安全策略
                - 配置资源共享的方式和目标方

                前端：node + vue -> admin.meetingfilm.com
                后端：springboot -> backend.meetingfilm.com

                缺陷：如果出现跨域策略不足的情况，需要修改代码，重新部署 -> 建议nginx来配置
         */

        return null;
    }
}
