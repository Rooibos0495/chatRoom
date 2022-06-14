package com.example.my_books.weblogin;
import com.example.my_books.base.Result;
import com.example.my_books.service.SysUserService;
import org.apache.commons.lang3.StringUtils;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器--实现
 * @author ZhaoYuYang
 * @date 2022/4/15
 * @Description
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        //从请求头中获取token
        String token = request.getHeader("X-Auth-Token");

        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }else {
            if (StringUtils.isEmpty(token)){
                response.sendRedirect("/login");
                return false;
            }else {
                //验证token是否正确
                Object data = sysUserService.isToken(token).getData();
                if (ObjectUtils.isEmpty(data)){
                    return false;
                }
            }
        }
        return true;
    }
}
