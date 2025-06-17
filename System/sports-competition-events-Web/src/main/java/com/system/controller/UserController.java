package com.system.controller;

import com.system.common.entity.User;
import com.system.common.entity.FileSystem;
import com.system.tools.ToolRandom;
import com.system.common.CommonPower;
import com.system.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private com.system.service.UserService UserService;
    @Autowired
    private com.system.tools.ToolUser ToolUser;
    @Autowired
    private com.system.service.FileSystemService FileSystemService;

    //-------------------------页面跳转通用部分--------------------------
    //跳转 新增或者修改页面
    @RequestMapping("/addOrUpView")
    public ModelAndView addOrUpView(HttpServletResponse resp, HttpServletRequest req, User o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/User/addOrUp");
        //id非空则进行修改
        if (!StringUtils.isEmpty(o.getId())) {
            final User build = User.builder().id(o.getId()).build();
            final User search = UserService.get(build);
            mv.addObject("function", "update");
            o = search;
        } else {
            //新增
            mv.addObject("function", "add");
        }
        mv.addObject("obj", o);
        mv.addObject("modular", User.modular);
        mv.addObject("leftModular", pageModular + "AddOrUpView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/adminView")
    public ModelAndView adminView(HttpServletResponse resp, HttpServletRequest req, User o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/User/admin");
        mv.addObject("list", UserService.getAll2Page(o));
        mv.addObject("count", UserService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", User.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "AdminView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/indexView")
    public ModelAndView indexView(HttpServletResponse resp, HttpServletRequest req, User o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/User/index");
        mv.addObject("list", UserService.getAll2Page(o));
        mv.addObject("count", UserService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", User.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "IndexView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/detailsView")
    public ModelAndView detailsView(HttpServletResponse resp, HttpServletRequest req, User o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/User/details");
        mv.addObject("list", UserService.getAll2Page(o));
        mv.addObject("count", UserService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", User.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "detailsView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //-------------------------通用部分--------------------------
    //查询总数
    @RequestMapping("/count")
    @ResponseBody
    public Integer count(HttpServletResponse resp, HttpServletRequest req, User o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        return UserService.count(o);
    }

    //表格异步 分页查询
    @RequestMapping("/getAll2Table")
    @ResponseBody
    public Map<String, Object> getAll2Table(HttpServletResponse resp, HttpServletRequest req, User o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", UserService.count(o));
        returnMap.put("rows", UserService.getAll2Page(o));
        return returnMap;
    }

    //查询
    @RequestMapping("/getAll2Page")
    @ResponseBody
    public List<User> getAll2Page(HttpServletResponse resp, HttpServletRequest req, User o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        return UserService.getAll2Page(o);
    }

    //查询
    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(HttpServletResponse resp, HttpServletRequest req, User o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        return UserService.getAll(o);
    }

    //查询
    @RequestMapping("/get")
    @ResponseBody
    public User get(HttpServletResponse resp, HttpServletRequest req, User o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        return UserService.get(o);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletResponse resp, HttpServletRequest req, User o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        String isSuccess = "true";
        final User add = UserService.add(o);
        if (null == add) {
            isSuccess = "false-has-double";
        }
        return isSuccess;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletResponse resp, HttpServletRequest req, User o) {
        return UserService.del(o);
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletResponse resp, HttpServletRequest req, User o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setId(us.getId());
        }
        return UserService.update(o);
    }
}
