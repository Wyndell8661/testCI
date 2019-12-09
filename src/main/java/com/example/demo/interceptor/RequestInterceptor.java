package com.example.demo.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: JinWenPeng
 * @Date: 2019/11/30 14:35
 */

/**
 * 添加MDC日志
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private final static Logger log = LoggerFactory.getLogger(RequestInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String unqId = RandomStringUtils.randomNumeric(16);
        MDC.put("requestId",unqId);
        MDC.put("requestUrl",request.getRequestURI());
        MDC.put("beginTime",System.currentTimeMillis()+"");

        log.info("reqestId : {}, reqestUri : {},  reqmethod : {}, param : {}",
                unqId, request.getRequestURI(), request.getMethod(),
                JSON.toJSONString(request.getParameterMap()));

        return super.preHandle(request,response,handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("requestId : {}, 请求：{}, 耗时：{} ms",
                MDC.get("requestId"), MDC.get("requestUrl"), System.currentTimeMillis() - Long.parseLong(MDC.get("beginTime")));
        MDC.remove("requestId");
        MDC.remove("requestUrl");
        MDC.remove("beginTime");

        super.afterCompletion(request, response, handler, ex);
    }
}
