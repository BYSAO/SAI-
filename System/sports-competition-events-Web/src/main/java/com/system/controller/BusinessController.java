package com.system.controller;

import com.system.common.entity.Business;
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
@RequestMapping("/Business")
public class BusinessController {
    @Autowired
    private com.system.service.BusinessService BusinessService;
    @Autowired
    private com.system.tools.ToolUser ToolUser;
    @Autowired
    private com.system.service.FileSystemService FileSystemService;

    //-------------------------页面跳转通用部分--------------------------
    //跳转 新增或者修改页面
    @RequestMapping("/addOrUpView")
    public ModelAndView addOrUpView(HttpServletResponse resp, HttpServletRequest req, Business o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Business/addOrUp");
        //id非空则进行修改
        if (!StringUtils.isEmpty(o.getId())) {
            final Business build = Business.builder().id(o.getId()).build();
            final Business search = BusinessService.get(build);
            mv.addObject("function", "update");
            o = search;
        } else {
            //新增
            mv.addObject("function", "add");
        }
        mv.addObject("obj", o);
        mv.addObject("modular", Business.modular);
        mv.addObject("leftModular", pageModular + "AddOrUpView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/adminView")
    public ModelAndView adminView(HttpServletResponse resp, HttpServletRequest req, Business o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Business/admin");
        mv.addObject("list", BusinessService.getAll2Page(o));
        mv.addObject("count", BusinessService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Business.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "AdminView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/indexView")
    public ModelAndView indexView(HttpServletResponse resp, HttpServletRequest req, Business o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Business/index");
        mv.addObject("list", BusinessService.getAll2Page(o));
        mv.addObject("count", BusinessService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Business.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "IndexView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/detailsView")
    public ModelAndView detailsView(HttpServletResponse resp, HttpServletRequest req, Business o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Business/details");
        mv.addObject("list", BusinessService.getAll2Page(o));
        mv.addObject("count", BusinessService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Business.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "detailsView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //-------------------------通用部分--------------------------
    //查询总数
    @RequestMapping("/count")
    @ResponseBody
    public Integer count(HttpServletResponse resp, HttpServletRequest req, Business o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return BusinessService.count(o);
    }

    //表格异步 分页查询
    @RequestMapping("/getAll2Table")
    @ResponseBody
    public Map<String, Object> getAll2Table(HttpServletResponse resp, HttpServletRequest req, Business o) {
        final User us = ToolUser.getUserMessageForSession(req);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", BusinessService.count(o));
        returnMap.put("rows", BusinessService.getAll2Page(o));
        return returnMap;
    }

    //查询
    @RequestMapping("/getAll2Page")
    @ResponseBody
    public List<Business> getAll2Page(HttpServletResponse resp, HttpServletRequest req, Business o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return BusinessService.getAll2Page(o);
    }

    //查询
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Business> getAll(HttpServletResponse resp, HttpServletRequest req, Business o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return BusinessService.getAll(o);
    }

    //查询
    @RequestMapping("/get")
    @ResponseBody
    public Business get(HttpServletResponse resp, HttpServletRequest req, Business o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return BusinessService.get(o);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletResponse resp, HttpServletRequest req, Business o) {
        final User us = ToolUser.getUserMessageForSession(req);

        String isSuccess = "true";
        final Business add = BusinessService.add(o);
        //添加图片
        if (null != o.getFileListString()) {
            for (String s : o.getFileListString().split("■")) {
                FileSystem fileParam = new FileSystem();
                fileParam.setType(Business.modular);
                fileParam.setPath(s);
                fileParam.setDownName(ToolRandom.returnRandomString());
                fileParam.setRelevancy(String.valueOf(add.getId()));
                FileSystemService.add(fileParam);
            }
        }
        if (null == add) {
            isSuccess = "false-has-double";
        }
        return isSuccess;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletResponse resp, HttpServletRequest req, Business o) {
        return BusinessService.del(o);
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletResponse resp, HttpServletRequest req, Business o) {
        final User us = ToolUser.getUserMessageForSession(req);

        //更新图片
        if (null != o.getFileListString()) {
            for (String s : o.getFileListString().split("■")) {
                FileSystem fileParam = new FileSystem();
                fileParam.setType(Business.modular);
                fileParam.setPath(s);
                fileParam.setDownName(ToolRandom.returnRandomString());
                fileParam.setRelevancy(String.valueOf(o.getId()));
                FileSystemService.add(fileParam);
            }
        }
        return BusinessService.update(o);
    }
}
