package com.system.controller;

import com.system.common.entity.Project;
import com.system.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Project")
public class ProjectController {
    @Autowired
    private ProjectService ProjectService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<Project> getAll(@RequestBody Project t) {
        return ProjectService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<Project> getAll2Page(@RequestBody Project t) {
        return ProjectService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody Project t) {
        return ProjectService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public Project get(@RequestBody Project t) {
        return ProjectService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public Project add(@RequestBody Project t) {
        return ProjectService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<Project> t) {
        return ProjectService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody Project t) {
        return ProjectService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody Project t) {
        return ProjectService.update(t);
    }
}
