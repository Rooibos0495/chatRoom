package com.example.my_books.weblogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;


@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 不需拦截-白名单
     */
    private static final String[] WHITELIST = {
            // 登录相关
            "/sysUser/login",
            "/sysUser/addUserInfo"
    };

    /**
     * 配置拦截器，重写add方法
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                //全部拦截
                .addPathPatterns("/**")
                .excludePathPatterns(WHITELIST);//排除拦截
    }
}
