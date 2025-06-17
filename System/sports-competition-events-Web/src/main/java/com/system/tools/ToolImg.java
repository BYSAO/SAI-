package com.system.tools;

import org.apache.poi.util.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;

public class ToolImg {

    /**
     * 将图片保存为bate数组
     *
     * @param imagePath 图片地址
     * @return
     */
    public static byte[] returnImgToBate(String imagePath) {
        if (null == imagePath || "".equals(imagePath)) {
            return null;
        }
        byte[] byteImage = null;
        InputStream is = null;
        try {
            is = new FileInputStream(imagePath);
            // 将输入流转化为数组
            byteImage = IOUtils.toByteArray(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return byteImage;
    }
}
