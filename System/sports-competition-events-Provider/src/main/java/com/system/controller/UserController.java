package com.system.controller;

import com.system.common.entity.User;
import com.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService UserService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<User> getAll(@RequestBody User t) {
        return UserService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<User> getAll2Page(@RequestBody User t) {
        return UserService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody User t) {
        return UserService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public User get(@RequestBody User t) {
        return UserService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public User add(@RequestBody User t) {
        return UserService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<User> t) {
        return UserService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody User t) {
        return UserService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody User t) {
        return UserService.update(t);
    }
}
