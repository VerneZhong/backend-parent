package com.zxb.meetingfilm.api.gateway.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zxb.meetingfilm.utils.properties.JwtProperties;
import com.zxb.meetingfilm.utils.properties.JwtTokenUtil;
import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import io.jsonwebtoken.JwtException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-02 10:58
 */
public class JWTFilter extends ZuulFilter {
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
        RequestContext requestContext = RequestContext.getCurrentContext();

        // Jwt 工具类
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        JwtProperties jwtProperties = JwtProperties.getJwtProperties();

        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();

        // 提前设置请求继续，如果失败则修改内容
        requestContext.setSendZuulResponse(true);
        requestContext.setResponseStatusCode(200);

        // 允许登陆通过
        if (request.getServletPath().endsWith("/" + jwtProperties.getAuthPath())) {
            return null;
        }

        // 1. 验证Token有效性 -> 用户是否登陆过
        String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);

            // 验证token是否过期，包含验证jwt是否正确
            try {
                if (jwtTokenUtil.isTokenExpired(authToken)) {
                    renderJson(requestContext, response, BaseResponseVO.noLogin());
                } else {
                    // 2. 解析出JWT中payload -> userId -> randomKey
                    String randomKey = jwtTokenUtil.getMd5KeyFromToken(authToken);
                    String userId = jwtTokenUtil.getUsernameFromToken(authToken);

                    // 3. 是否需要验签，以及验签的算法：MD5或是AES等等

                    // 4. 判断userId是否有效
                    // TODO 数据库验证
                }
            } catch (JwtException e) {
                renderJson(requestContext, response, BaseResponseVO.noLogin());
            }
        } else {
            renderJson(requestContext, response, BaseResponseVO.noLogin());
        }
        return null;
    }

    /**
     * 渲染Json对象
     * @param context
     * @param response
     * @param json
     */
    private void renderJson(RequestContext context, HttpServletResponse response, Object json) {
        // 设置终止请求
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        context.setSendZuulResponse(false);
        context.setResponseBody(JSONObject.toJSONString(json));
    }
}
