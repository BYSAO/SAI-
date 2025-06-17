package com.system.controller;


import com.system.common.entity.FileSystem;
import com.system.service.FileSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/FileSystem")
public class FileSystemController {

    @Autowired
    private FileSystemService FileSystemService;

    @RequestMapping("/getAll")
    @ResponseBody
    //查询全部
    public List<FileSystem> getAll(@RequestBody FileSystem t) {
        return FileSystemService.getAll(t);
    }

    @RequestMapping("/getAll2Page")
    @ResponseBody
    //查询全部
    public List<FileSystem> getAll2Page(@RequestBody FileSystem t) {
        return FileSystemService.getAll2Page(t);
    }

    @RequestMapping("/count")
    @ResponseBody
    //查询总数
    public Integer count(@RequestBody FileSystem t) {
        return FileSystemService.count(t);
    }

    @RequestMapping("/get")
    @ResponseBody
    //查询
    public FileSystem get(@RequestBody FileSystem t) {
        return FileSystemService.get(t);
    }

    @RequestMapping("/add")
    @ResponseBody
    //增加
    public FileSystem add(@RequestBody FileSystem t) {
        return FileSystemService.add(t);
    }

    @RequestMapping("/addS")
    @ResponseBody
    //增加
    public String addS(@RequestBody List<FileSystem> t) {
        return FileSystemService.addS(t);
    }

    @RequestMapping("/del")
    @ResponseBody
    //删除
    public String del(@RequestBody FileSystem t) {
        return FileSystemService.del(t);
    }

    @RequestMapping("/update")
    @ResponseBody
    //修改
    public String update(@RequestBody FileSystem t) {
        return FileSystemService.update(t);
    }


}
