package com.system.tools;


import com.system.common.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ToolUser {

    public User getUserMessageForSession(HttpServletRequest request) {
        User user = null;
        Object users = request.getSession().getAttribute("users");
        try {
            //获取当前用户
            if (null != users) {
                user = (User) request.getSession().getAttribute("users");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == user) {
            user = new User();
            //user.setUserName("游客");
        }
        return user;
    }
}
