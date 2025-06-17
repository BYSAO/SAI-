package com.system.common.entity;

import com.system.common.CommonEntity;
import com.system.common.entity.User;
import com.system.common.entity.Project;

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
public class Achievement {

    //主要用于识别到当前模块内容为哪一部分
    public static final String modular = "Achievement";
    //此处属性与数据库表保持一致
    public static final String mysqlTableName = "Achievement";
    public static final String serviceModular = "system-provider";
    public static final String PAYMENT_URL = "/" + serviceModular + "/" + modular;
    //页数
    private Integer page = 1;
    //条数
    private Integer rows = 10;
    //识别当前数据库指定数据是否有效
    private Integer isDel;
    private boolean isMy = false;


    // 比赛成绩 对象的唯一ID属性
    private Integer id;
    // 比赛成绩 对象的数据变更时间属性
    private String time;
    // 比赛成绩 对象的成绩属性
    private Integer num;
    // 比赛成绩 对象的开始时间属性
    private String start;
    // 比赛成绩 对象的结束时间属性
    private String end;
    // 比赛成绩 对象的运动员属性
    private Integer User;
    // 比赛成绩 对象的运动员详情属性
    private User UserObj;
    // 比赛成绩 对象的项目属性
    private Integer Project;
    // 比赛成绩 对象的项目详情属性
    private Project ProjectObj;
    // 比赛成绩 对象的类型标题属性
    private String title;
    // 比赛成绩 对象的类型说明属性
    private String text;

    private String pm;
    private String ranking;
}
