package com.system.controller;

import com.system.common.entity.VolunteerServeDetails;
import com.system.service.VolunteerServeDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/VolunteerServeDetails")
public class VolunteerServeDetailsController {
    @Autowired
    private VolunteerServeDetailsService VolunteerServeDetailsService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<VolunteerServeDetails> getAll(@RequestBody VolunteerServeDetails t) {
        return VolunteerServeDetailsService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<VolunteerServeDetails> getAll2Page(@RequestBody VolunteerServeDetails t) {
        return VolunteerServeDetailsService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody VolunteerServeDetails t) {
        return VolunteerServeDetailsService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public VolunteerServeDetails get(@RequestBody VolunteerServeDetails t) {
        return VolunteerServeDetailsService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public VolunteerServeDetails add(@RequestBody VolunteerServeDetails t) {
        return VolunteerServeDetailsService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<VolunteerServeDetails> t) {
        return VolunteerServeDetailsService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody VolunteerServeDetails t) {
        return VolunteerServeDetailsService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody VolunteerServeDetails t) {
        return VolunteerServeDetailsService.update(t);
    }
}
