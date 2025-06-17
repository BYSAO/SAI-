package com.system.controller;

import com.system.common.entity.Business;
import com.system.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Business")
public class BusinessController {
    @Autowired
    private BusinessService BusinessService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<Business> getAll(@RequestBody Business t) {
        return BusinessService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<Business> getAll2Page(@RequestBody Business t) {
        return BusinessService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody Business t) {
        return BusinessService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public Business get(@RequestBody Business t) {
        return BusinessService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public Business add(@RequestBody Business t) {
        return BusinessService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<Business> t) {
        return BusinessService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody Business t) {
        return BusinessService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody Business t) {
        return BusinessService.update(t);
    }
}
