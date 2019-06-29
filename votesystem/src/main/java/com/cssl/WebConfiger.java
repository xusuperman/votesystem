package com.cssl;

import com.cssl.Interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class WebConfiger implements WebMvcConfigurer{


   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor inter=new MyInterceptor();
        registry.addInterceptor(inter).addPathPatterns("/**").excludePathPatterns("/images/**","/css/**","/front/**","/js/**");
    }


}
