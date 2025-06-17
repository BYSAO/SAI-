package com.system.controller;

import com.system.common.entity.Information;
import com.system.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Information")
public class InformationController {
    @Autowired
    private InformationService InformationService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<Information> getAll(@RequestBody Information t) {
        return InformationService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<Information> getAll2Page(@RequestBody Information t) {
        return InformationService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody Information t) {
        return InformationService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public Information get(@RequestBody Information t) {
        return InformationService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public Information add(@RequestBody Information t) {
        return InformationService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<Information> t) {
        return InformationService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody Information t) {
        return InformationService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody Information t) {
        return InformationService.update(t);
    }
}
