package com.system.controller;

import com.system.common.entity.Achievement;
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
@RequestMapping("/Achievement")
public class AchievementController {
    @Autowired
    private com.system.service.AchievementService AchievementService;
    @Autowired
    private com.system.tools.ToolUser ToolUser;
    @Autowired
    private com.system.service.FileSystemService FileSystemService;

    //-------------------------页面跳转通用部分--------------------------
    //跳转 新增或者修改页面
    @RequestMapping("/addOrUpView")
    public ModelAndView addOrUpView(HttpServletResponse resp, HttpServletRequest req, Achievement o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Achievement/addOrUp");
        //id非空则进行修改
        if (!StringUtils.isEmpty(o.getId())) {
            final Achievement build = Achievement.builder().id(o.getId()).build();
            final Achievement search = AchievementService.get(build);
            mv.addObject("function", "update");
            o = search;
        } else {
            //新增
            mv.addObject("function", "add");
        }
        mv.addObject("obj", o);
        mv.addObject("modular", Achievement.modular);
        mv.addObject("leftModular", pageModular + "AddOrUpView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/adminView")
    public ModelAndView adminView(HttpServletResponse resp, HttpServletRequest req, Achievement o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Achievement/admin");
        mv.addObject("list", AchievementService.getAll2Page(o));
        mv.addObject("count", AchievementService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Achievement.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "AdminView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/indexView")
    public ModelAndView indexView(HttpServletResponse resp, HttpServletRequest req, Achievement o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Achievement/index");
        mv.addObject("list", AchievementService.getAll2Page(o));
        mv.addObject("count", AchievementService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Achievement.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "IndexView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/detailsView")
    public ModelAndView detailsView(HttpServletResponse resp, HttpServletRequest req, Achievement o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Achievement/details");
        mv.addObject("list", AchievementService.getAll2Page(o));
        mv.addObject("count", AchievementService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Achievement.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "detailsView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //-------------------------通用部分--------------------------
    //查询总数
    @RequestMapping("/count")
    @ResponseBody
    public Integer count(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        return AchievementService.count(o);
    }

    //表格异步 分页查询
    @RequestMapping("/getAll2Table")
    @ResponseBody
    public Map<String, Object> getAll2Table(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", AchievementService.count(o));
        returnMap.put("rows", AchievementService.getAll2Page(o));
        return returnMap;
    }

    //查询
    @RequestMapping("/getAll2Page")
    @ResponseBody
    public List<Achievement> getAll2Page(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        return AchievementService.getAll2Page(o);
    }

    //查询
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Achievement> getAll(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        return AchievementService.getAll(o);
    }

    //查询
    @RequestMapping("/get")
    @ResponseBody
    public Achievement get(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        return AchievementService.get(o);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        String isSuccess = "true";
        final Achievement add = AchievementService.add(o);
        if (null == add) {
            isSuccess = "false-has-double";
        }
        return isSuccess;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        return AchievementService.del(o);
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletResponse resp, HttpServletRequest req, Achievement o) {
        final User us = ToolUser.getUserMessageForSession(req);
        if (o.isMy()) {
            o.setUser(us.getId());
        }
        return AchievementService.update(o);
    }
}
