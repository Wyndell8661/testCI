package com.example.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)
            throws Exception {
        //        response.setContentType("application/json; charset=UTF-8");
        //        response.getWriter().print("您被拦截了");
        //        //返回false时是一个空response，需要在response里自己写内容；
        return true;
    }
}
