package com.cssl.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MyInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("request请求地址path[{}] uri[{}]", request.getServletPath(), request.getRequestURI());
        String url = request.getRequestURI();
            if (url.endsWith("login.html") || url.endsWith("denglu")) {
              return true;
            }

            Object obj = request.getSession().getAttribute("user");
            if (obj == null) {
                response.sendRedirect("login.html");
                return false;
            } else {
                return true;
            }



    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion.........");
    }
}
