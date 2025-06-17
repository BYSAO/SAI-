package com.system.common.entity;

import com.system.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {

    //主要用于识别到当前模块内容为哪一部分
    public static final String modular = "Notice";
    //此处属性与数据库表保持一致
    public static final String mysqlTableName = "Notice";
    public static final String serviceModular = "system-provider";
    public static final String PAYMENT_URL = "/" + serviceModular + "/" + modular;
    //页数
    private Integer page = 1;
    //条数
    private Integer rows = 10;
    //识别当前数据库指定数据是否有效
    private Integer isDel;
    private boolean isMy = false;


    // 公告 对象的唯一ID属性
    private Integer id;
    // 公告 对象的数据变更时间属性
    private String time;
    // 公告 对象的公告标题属性
    private String title;
    // 公告 对象的公告内容属性
    private String text;
}
