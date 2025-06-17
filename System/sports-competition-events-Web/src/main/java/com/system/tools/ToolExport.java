package com.system.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//文件导出,下载公共类
public class ToolExport {


    // 字符编码格式
    public static String charsetCode = "utf-8";

    /**
     * 基础字节数组输出
     */
    public static void outStream(InputStream is, OutputStream os) {
        try {
            byte[] buffer = new byte[10240];
            int length = -1;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
                os.flush();
            }
        } catch (Exception e) {
            System.out.println("执行 outStream 发生了异常：" + e.getMessage());
        } finally {
            try {
                os.close();
            } catch (IOException e) {
            }
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * 文件的内容类型
     */
    public static String getFileContentType(String name) {
        String result = "";
        String fileType = name.toLowerCase();
        if (fileType.endsWith(".png")) {
            result = "image/png";
        } else if (fileType.endsWith(".gif")) {
            result = "image/gif";
        } else if (fileType.endsWith(".jpg") || fileType.endsWith(".jpeg")) {
            result = "image/jpeg";
        } else if (fileType.endsWith(".svg")) {
            result = "image/svg+xml";
        } else if (fileType.endsWith(".doc")) {
            result = "application/msword";
        } else if (fileType.endsWith(".xls")) {
            result = "application/x-excel";
        } else if (fileType.endsWith(".zip")) {
            result = "application/zip";
        } else if (fileType.endsWith(".pdf")) {
            result = "application/pdf";
        } else if (fileType.endsWith(".xlsx") || fileType.endsWith(".xls")) {
            result = "application/vnd.ms-excel";
        } else {
            result = "application/octet-stream";
        }
        return result;
    }
}
