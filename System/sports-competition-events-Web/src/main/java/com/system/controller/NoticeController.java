package com.system.controller;

import com.system.common.entity.Notice;
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
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    private com.system.service.NoticeService NoticeService;
    @Autowired
    private com.system.tools.ToolUser ToolUser;
    @Autowired
    private com.system.service.FileSystemService FileSystemService;

    //-------------------------页面跳转通用部分--------------------------
    //跳转 新增或者修改页面
    @RequestMapping("/addOrUpView")
    public ModelAndView addOrUpView(HttpServletResponse resp, HttpServletRequest req, Notice o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Notice/addOrUp");
        //id非空则进行修改
        if (!StringUtils.isEmpty(o.getId())) {
            final Notice build = Notice.builder().id(o.getId()).build();
            final Notice search = NoticeService.get(build);
            mv.addObject("function", "update");
            o = search;
        } else {
            //新增
            mv.addObject("function", "add");
        }
        mv.addObject("obj", o);
        mv.addObject("modular", Notice.modular);
        mv.addObject("leftModular", pageModular + "AddOrUpView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/adminView")
    public ModelAndView adminView(HttpServletResponse resp, HttpServletRequest req, Notice o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Notice/admin");
        mv.addObject("list", NoticeService.getAll2Page(o));
        mv.addObject("count", NoticeService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Notice.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "AdminView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/indexView")
    public ModelAndView indexView(HttpServletResponse resp, HttpServletRequest req, Notice o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Notice/index");
        mv.addObject("list", NoticeService.getAll2Page(o));
        mv.addObject("count", NoticeService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Notice.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "IndexView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/detailsView")
    public ModelAndView detailsView(HttpServletResponse resp, HttpServletRequest req, Notice o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Notice/details");
        mv.addObject("list", NoticeService.getAll2Page(o));
        mv.addObject("count", NoticeService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Notice.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "detailsView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //-------------------------通用部分--------------------------
    //查询总数
    @RequestMapping("/count")
    @ResponseBody
    public Integer count(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return NoticeService.count(o);
    }

    //表格异步 分页查询
    @RequestMapping("/getAll2Table")
    @ResponseBody
    public Map<String, Object> getAll2Table(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        final User us = ToolUser.getUserMessageForSession(req);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", NoticeService.count(o));
        returnMap.put("rows", NoticeService.getAll2Page(o));
        return returnMap;
    }

    //查询
    @RequestMapping("/getAll2Page")
    @ResponseBody
    public List<Notice> getAll2Page(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return NoticeService.getAll2Page(o);
    }

    //查询
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Notice> getAll(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return NoticeService.getAll(o);
    }

    //查询
    @RequestMapping("/get")
    @ResponseBody
    public Notice get(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return NoticeService.get(o);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        final User us = ToolUser.getUserMessageForSession(req);

        String isSuccess = "true";
        final Notice add = NoticeService.add(o);
        if (null == add) {
            isSuccess = "false-has-double";
        }
        return isSuccess;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        return NoticeService.del(o);
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletResponse resp, HttpServletRequest req, Notice o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return NoticeService.update(o);
    }
}
