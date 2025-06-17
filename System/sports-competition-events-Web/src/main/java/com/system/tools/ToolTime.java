package com.system.tools;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ToolTime {
    /**
     * 获取当前时间
     *
     * @return
     */
    public String getTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    /**
     * 获取精确到毫秒的时间戳
     *
     * @param
     * @return
     **/
    public Long getTimestamp() {
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime());
        return Long.valueOf(timestamp);
    }
}
