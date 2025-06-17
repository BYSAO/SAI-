package com.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.common.entity.FileSystem;
import com.system.service.FileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/File")
public class FileSystemController {
    @Autowired
    private FileSystemService FileSystemService;

    @Autowired
    private com.system.tools.ToolFile ToolFile;


    //文件上传 所有文件上传通用
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = ToolFile.uploadFile(file, -1, request);
        return jsonObject;
    }

    //文件上传 限制大小40000 图片上传
    @RequestMapping(value = "/uploadMessageImg", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadMessageImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = ToolFile.uploadFile(file, 40000, request);
        return jsonObject;
    }

    //文件上传 不限制大小 图片上传
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = ToolFile.uploadFile(file, -1, request);
        return jsonObject;
    }

    @RequestMapping("/down")
    public void down(FileSystem apiFile, HttpServletResponse resp, HttpServletRequest req) {

        com.system.tools.ToolFile.downFile(apiFile.getPath(), apiFile.getDownName(), resp, req);
    }

    //-------------------------通用部分--------------------------
    //表格异步 分页查询
    @RequestMapping("/getAll2Table")
    @ResponseBody
    public Map<String, Object> getAll2Table(HttpServletResponse resp, HttpServletRequest req, FileSystem o) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", FileSystemService.count(o));
        returnMap.put("rows", FileSystemService.getAll2Page(o));
        return returnMap;
    }

    //查询
    @RequestMapping("/getAll2Page")
    @ResponseBody
    public List<FileSystem> getAll2Page(HttpServletResponse resp, HttpServletRequest req, FileSystem o) {
        return FileSystemService.getAll2Page(o);
    }

    //查询
    @RequestMapping("/getAll")
    @ResponseBody
    public List<FileSystem> getAll(HttpServletResponse resp, HttpServletRequest req, FileSystem o) {
        return FileSystemService.getAll(o);
    }

    //查询
    @RequestMapping("/get")
    @ResponseBody
    public FileSystem get(HttpServletResponse resp, HttpServletRequest req, FileSystem o) {
        return FileSystemService.get(o);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletResponse resp, HttpServletRequest req, FileSystem o) {

        String isSuccess = "true";
        final FileSystem add = FileSystemService.add(o);
        if (null == add) {
            isSuccess = "false-has-double";
        }
        return isSuccess;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletResponse resp, HttpServletRequest req, FileSystem o) {
        return FileSystemService.del(o);
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletResponse resp, HttpServletRequest req, FileSystem o) {
        return FileSystemService.update(o);
    }


}
