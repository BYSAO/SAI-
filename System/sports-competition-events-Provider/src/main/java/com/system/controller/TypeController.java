package com.system.controller;

import com.system.common.entity.Type;
import com.system.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Type")
public class TypeController {
    @Autowired
    private TypeService TypeService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<Type> getAll(@RequestBody Type t) {
        return TypeService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<Type> getAll2Page(@RequestBody Type t) {
        return TypeService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody Type t) {
        return TypeService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public Type get(@RequestBody Type t) {
        return TypeService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public Type add(@RequestBody Type t) {
        return TypeService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<Type> t) {
        return TypeService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody Type t) {
        return TypeService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody Type t) {
        return TypeService.update(t);
    }
}
