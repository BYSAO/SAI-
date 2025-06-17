package com.system.controller;

import com.system.common.entity.Type;
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
@RequestMapping("/Type")
public class TypeController {
    @Autowired
    private com.system.service.TypeService TypeService;
    @Autowired
    private com.system.tools.ToolUser ToolUser;
    @Autowired
    private com.system.service.FileSystemService FileSystemService;

    //-------------------------页面跳转通用部分--------------------------
    //跳转 新增或者修改页面
    @RequestMapping("/addOrUpView")
    public ModelAndView addOrUpView(HttpServletResponse resp, HttpServletRequest req, Type o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Type/addOrUp");
        //id非空则进行修改
        if (!StringUtils.isEmpty(o.getId())) {
            final Type build = Type.builder().id(o.getId()).build();
            final Type search = TypeService.get(build);
            mv.addObject("function", "update");
            o = search;
        } else {
            //新增
            mv.addObject("function", "add");
        }
        mv.addObject("obj", o);
        mv.addObject("modular", Type.modular);
        mv.addObject("leftModular", pageModular + "AddOrUpView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/adminView")
    public ModelAndView adminView(HttpServletResponse resp, HttpServletRequest req, Type o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Type/admin");
        mv.addObject("list", TypeService.getAll2Page(o));
        mv.addObject("count", TypeService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Type.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "AdminView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/indexView")
    public ModelAndView indexView(HttpServletResponse resp, HttpServletRequest req, Type o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);

        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Type/index");
        mv.addObject("list", TypeService.getAll2Page(o));
        mv.addObject("count", TypeService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Type.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "IndexView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //跳转
    @RequestMapping("/detailsView")
    public ModelAndView detailsView(HttpServletResponse resp, HttpServletRequest req, Type o, String pageModular) {
        final User us = ToolUser.getUserMessageForSession(req);
        final CommonPower enumPower = CommonPower.getEnumPower(us.getLv());
        if (!enumPower.getPowerCode().equals(pageModular)) {
            ModelAndView mv = new ModelAndView("/pages/noPower");
            return mv;
        }
        ModelAndView mv = new ModelAndView("/pages/" + pageModular + "/Type/details");
        mv.addObject("list", TypeService.getAll2Page(o));
        mv.addObject("count", TypeService.count(o));
        mv.addObject("page", o.getPage());
        mv.addObject("rows", o.getRows());
        mv.addObject("modular", Type.modular);
        mv.addObject("searchParam", o);
        mv.addObject("leftModular", pageModular + "detailsView");
        mv.addObject("pageModular", pageModular);
        return mv;
    }

    //-------------------------通用部分--------------------------
    //查询总数
    @RequestMapping("/count")
    @ResponseBody
    public Integer count(HttpServletResponse resp, HttpServletRequest req, Type o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return TypeService.count(o);
    }

    //表格异步 分页查询
    @RequestMapping("/getAll2Table")
    @ResponseBody
    public Map<String, Object> getAll2Table(HttpServletResponse resp, HttpServletRequest req, Type o) {
        final User us = ToolUser.getUserMessageForSession(req);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", TypeService.count(o));
        returnMap.put("rows", TypeService.getAll2Page(o));
        return returnMap;
    }

    //查询
    @RequestMapping("/getAll2Page")
    @ResponseBody
    public List<Type> getAll2Page(HttpServletResponse resp, HttpServletRequest req, Type o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return TypeService.getAll2Page(o);
    }

    //查询
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Type> getAll(HttpServletResponse resp, HttpServletRequest req, Type o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return TypeService.getAll(o);
    }

    //查询
    @RequestMapping("/get")
    @ResponseBody
    public Type get(HttpServletResponse resp, HttpServletRequest req, Type o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return TypeService.get(o);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletResponse resp, HttpServletRequest req, Type o) {
        final User us = ToolUser.getUserMessageForSession(req);

        String isSuccess = "true";
        final Type add = TypeService.add(o);
        if (null == add) {
            isSuccess = "false-has-double";
        }
        return isSuccess;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletResponse resp, HttpServletRequest req, Type o) {
        return TypeService.del(o);
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletResponse resp, HttpServletRequest req, Type o) {
        final User us = ToolUser.getUserMessageForSession(req);

        return TypeService.update(o);
    }
}
