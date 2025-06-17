package com.system.common.entity;

import com.system.common.CommonEntity;
import com.system.common.entity.Type;

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
public class Project {

    //主要用于识别到当前模块内容为哪一部分
    public static final String modular = "Project";
    //此处属性与数据库表保持一致
    public static final String mysqlTableName = "Project";
    public static final String serviceModular = "system-provider";
    public static final String PAYMENT_URL = "/" + serviceModular + "/" + modular;
    //页数
    private Integer page = 1;
    //条数
    private Integer rows = 10;
    //识别当前数据库指定数据是否有效
    private Integer isDel;
    private boolean isMy = false;


    //图像数据集合
    private List<FileSystem> fileList;
    //前台展示的第一个图像信息
    private String fileListShow;
    //前台存储的图像id，用户指定的字符分割
    private String fileListString;
    //是否存在图像数据
    private boolean hasFile = false;
    // 运动项目 对象的唯一ID属性
    private Integer id;
    // 运动项目 对象的数据变更时间属性
    private String time;
    // 运动项目 对象的项目类型属性
    private Integer Type;
    // 运动项目 对象的类型详情属性
    private Type TypeObj;
    // 运动项目 对象的开始时间属性
    private String start;
    // 运动项目 对象的地点属性
    private String addr;
    // 运动项目 对象的人数上限属性
    private Integer num;
    // 运动项目 对象的项目标题属性
    private String title;
    // 运动项目 对象的项目介绍属性
    private String text;
    // 运动项目 对象的状态属性
    private String status;
}