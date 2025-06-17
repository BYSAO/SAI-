package com.system.tools;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSONObject;
import com.system.common.entity.FileSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * 文件操作公共类
 * 1、文件上传
 * 2、文件下载
 */
@Component
public class ToolFile {
    private static String pathName = "SystemUpLoad";
    @Autowired
    private Environment environment;

    /**
     * 生成输出流,保存至系统
     *
     * @return
     * @throws FileNotFoundException
     */
    public static FileSystem outputStream() throws FileNotFoundException {
        String randomName = ToolRandom.returnRandomString() + ".xlsx";
        Properties properties = System.getProperties();
        String path = properties.getProperty("user.dir");

        if (properties.getProperty("os.name").toLowerCase().contains("win")) {
            path += "\\";
        } else {
            path += "/";
        }

        // 文件输出位置
        OutputStream out = new FileOutputStream(path + "/" + pathName + "/" + randomName);
        final FileSystem file = new FileSystem();
        file.setOutputStream(out);
        file.setPath(path + "/" + pathName + "/" + randomName);
        file.setSystemName(randomName);

        return file;
    }

    /**
     * 文件下载 与 文件获取
     *
     * @param filePath     原始文件路径(服务器上存储的)
     * @param downFileName 下载保存的文件名称(传递给浏览器的瘟检测)
     * @param resp
     * @param req
     */

    public static void downFile(String filePath, String downFileName, HttpServletResponse resp, HttpServletRequest req) {

        Properties properties = System.getProperties();
        String path = properties.getProperty("user.dir");
        if (properties.getProperty("os.name").toLowerCase().contains("win")) {
            path += "\\";
        } else {
            path += "/";
        }
        File outFile = new File(path + "/" + pathName + "/" + filePath);
        String suffix = filePath.substring(filePath.lastIndexOf(".") + 1);
        String fileName = downFileName + "." + suffix;


        if (outFile.isFile() && outFile.exists()) { //判断文件或目录是否存在
            try {
                // 设置响应的头部信息
                resp.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
                // 设置响应内容的类型
                resp.setContentType(ToolExport.getFileContentType(fileName) + "; charset=" + ToolExport.charsetCode);
                // 设置响应内容的长度
                resp.setContentLength((int) outFile.length());
                // 输出
                ToolExport.outStream(new FileInputStream(outFile), resp.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 文件上传
     *
     * @param file    前端文件
     * @param request
     * @return
     * @throws Exception
     */
    public JSONObject uploadFile(MultipartFile file, long fileSize, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        long size = file.getSize();

        if (size > fileSize && fileSize != -1) {
            jsonObject.put("error", 1);
            jsonObject.put("state", "error");
            jsonObject.put("message", "文件过大，请上传小于40KB，40000字节大小的文件");
            return jsonObject;
        }

        try {
            //获取文件名称
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

            if (StringUtils.isEmpty(fileName)) {
                jsonObject.put("state", "error");
                jsonObject.put("message", "文件名称为空");
            }

            String randomName = ToolRandom.returnRandomString();
            String s = randomName + "." + suffix;
            Properties properties = System.getProperties();
            String path = properties.getProperty("user.dir");
            if (properties.getProperty("os.name").toLowerCase().contains("win")) {
                path += "\\";
            } else {
                path += "/";
            }
            File dest = new File(new File(path).getAbsolutePath() + "/" + pathName + "/" + s);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            file.transferTo(dest); // 保存文件

            jsonObject.put("error", 0);
            jsonObject.put("state", "success");
            jsonObject.put("path", s);
            jsonObject.put("name", fileName);
            jsonObject.put("url", "http://localhost:" + environment.getProperty("server.port") + "/File/down?path=" + s + "&downName=" + randomName);
        } catch (Exception e) {
            e.printStackTrace();
            //当前属性是为了适配kindeditor 前台获取的字段类型
            jsonObject.put("error", 1);

            jsonObject.put("state", "error");
            jsonObject.put("message", e);

            /**
             *
             * kindeditor 数据样例
             *
             * //成功时
             * {
             *         "error" : 0,
             *         "url" : "http://www.example.com/path/to/file.ext"
             * }
             * //失败时
             * {
             *         "error" : 1,
             *         "message" : "错误信息"
             * }
             */
        }

        return jsonObject;
    }


}
