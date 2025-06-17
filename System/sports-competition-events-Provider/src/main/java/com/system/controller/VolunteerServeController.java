package com.system.controller;

import com.system.common.entity.VolunteerServe;
import com.system.service.VolunteerServeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/VolunteerServe")
public class VolunteerServeController {
    @Autowired
    private VolunteerServeService VolunteerServeService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<VolunteerServe> getAll(@RequestBody VolunteerServe t) {
        return VolunteerServeService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<VolunteerServe> getAll2Page(@RequestBody VolunteerServe t) {
        return VolunteerServeService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody VolunteerServe t) {
        return VolunteerServeService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public VolunteerServe get(@RequestBody VolunteerServe t) {
        return VolunteerServeService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public VolunteerServe add(@RequestBody VolunteerServe t) {
        return VolunteerServeService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<VolunteerServe> t) {
        return VolunteerServeService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody VolunteerServe t) {
        return VolunteerServeService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody VolunteerServe t) {
        return VolunteerServeService.update(t);
    }
}
