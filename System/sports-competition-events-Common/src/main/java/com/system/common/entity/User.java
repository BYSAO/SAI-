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
public class User {

    //主要用于识别到当前模块内容为哪一部分
    public static final String modular = "User";
    //此处属性与数据库表保持一致
    public static final String mysqlTableName = "User";
    public static final String serviceModular = "system-provider";
    public static final String PAYMENT_URL = "/" + serviceModular + "/" + modular;
    //页数
    private Integer page = 1;
    //条数
    private Integer rows = 10;
    //识别当前数据库指定数据是否有效
    private Integer isDel;
    private boolean isMy = false;


    // 用户 对象的唯一ID属性
    private Integer id;
    // 用户 对象的数据变更时间属性
    private String time;
    // 用户 对象的账号昵称属性
    private String title;
    // 用户 对象的账号属性
    private String account;
    // 用户 对象的密码属性
    private String pw;
    // 用户 对象的性别属性
    private String sex;
    // 用户 对象的姓名属性
    private String name;
    // 用户 对象的联系方式属性
    private String iphone;
    // 用户 对象的身份证号属性
    private String carId;
    // 用户 对象的出生日期属性
    private String birthday;
    // 用户 对象的地址属性
    private String addr;
    // 用户 对象的角色属性
    private String lv;
    // 用户 对象的个人简介属性
    private String text;
}
