package com.system.controller;

import com.system.common.entity.Achievement;
import com.system.service.AchievementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Achievement")
public class AchievementController {
    @Autowired
    private AchievementService AchievementService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<Achievement> getAll(@RequestBody Achievement t) {
        return AchievementService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<Achievement> getAll2Page(@RequestBody Achievement t) {
        return AchievementService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody Achievement t) {
        return AchievementService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public Achievement get(@RequestBody Achievement t) {
        return AchievementService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public Achievement add(@RequestBody Achievement t) {
        return AchievementService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<Achievement> t) {
        return AchievementService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody Achievement t) {
        return AchievementService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody Achievement t) {
        return AchievementService.update(t);
    }
}
