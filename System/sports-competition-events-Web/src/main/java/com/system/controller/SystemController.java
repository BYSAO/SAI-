package com.system.controller;

import com.system.common.entity.Project;
import com.system.common.entity.User;
import com.system.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")

public class SystemController {

    @Autowired
    private com.system.service.UserService UserService;
    @Autowired
    private ProjectService ProjectService;

    //退出登录
    @RequestMapping("/outSignIn")
    @ResponseBody
    public ModelAndView outSignIn(HttpServletRequest request) {
        request.getSession().setAttribute("users", null);
        ModelAndView mv = new ModelAndView("/pages/login");
        return mv;
    }

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public User login(HttpServletRequest request, User user) {
        User userSearch = UserService.get(user);
        if (null != userSearch && userSearch.getPw().equals(user.getPw())) {
            request.getSession().setAttribute("users", userSearch);
            return userSearch;
        }
        return null;
    }

    //跳转登陆页面
    @RequestMapping("/loginView")
    public ModelAndView loginView() {
        ModelAndView mv = new ModelAndView("/pages/login");
        return mv;
    }

    //跳转注册页面
    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("/pages/register");
        return mv;
    }

    //主页
    @RequestMapping("/")
    public ModelAndView index(HttpServletResponse resp, HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/pages/login");
        return mv;
    }


    //主页
    @RequestMapping("/staticProject")
    public ModelAndView staticProject(HttpServletResponse resp, HttpServletRequest req, Integer project) {
        ModelAndView mv = new ModelAndView("/pages/admin/static");
        final Project project1 = ProjectService.get(Project.builder().id(project).build());
        mv.addObject("project", project1);
        mv.addObject("pageModular", "admin");
        return mv;
    }


    //管理员主页
    @RequestMapping("/adminIndex")
    public ModelAndView adminIndex(HttpServletResponse resp, HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/pages/admin/index");
        mv.addObject("modular", "adminIndex");
        mv.addObject("pageModular", "admin");
        return mv;
    }

    //用户主页
    @RequestMapping("/userIndex")
    public ModelAndView userIndex(HttpServletResponse resp, HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/pages/user/index");
        mv.addObject("modular", "userIndex");
        mv.addObject("pageModular", "user");
        return mv;
    }

    //用户主页
    @RequestMapping("/volunteerIndex")
    public ModelAndView volunteerIndex(HttpServletResponse resp, HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/pages/volunteer/index");
        mv.addObject("modular", "volunteerIndex");
        mv.addObject("pageModular", "volunteer");
        return mv;
    }

}
