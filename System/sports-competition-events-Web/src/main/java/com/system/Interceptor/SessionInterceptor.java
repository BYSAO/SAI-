package com.system.Interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class SessionInterceptor implements HandlerInterceptor {


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        String requestURI = request.getRequestURI();

       /* User object = new User();
        object.setTitle("测试");
        object.setId(1);
        object.setLv("管理员");
        request.getSession().setAttribute("users", object);
        request.setAttribute("userMessage", object);

        return true;*/

        Object object = request.getSession().getAttribute("users");

        if (null != object) {
            request.setAttribute("userMessage", object);
        }

        if (

                requestURI.contains("/register") || requestURI.contains("/File") ||
                        requestURI.contains("/loginView") || //登录
                        requestURI.contains("/User/add") || //登录
                        requestURI.contains("/login") || //登录
                        // 系统首页
                        requestURI.equals("/")
        ) {
            if (null != object) {
                request.setAttribute("userMessage", object);
            }
            return true;
        }

        if (null == object) {
            request.getRequestDispatcher("/loginView").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
