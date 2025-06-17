package com.system.controller;

import com.system.common.entity.Notice;
import com.system.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    private NoticeService NoticeService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<Notice> getAll(@RequestBody Notice t) {
        return NoticeService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<Notice> getAll2Page(@RequestBody Notice t) {
        return NoticeService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody Notice t) {
        return NoticeService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public Notice get(@RequestBody Notice t) {
        return NoticeService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public Notice add(@RequestBody Notice t) {
        return NoticeService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<Notice> t) {
        return NoticeService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody Notice t) {
        return NoticeService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody Notice t) {
        return NoticeService.update(t);
    }
}
