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
public class Business {

    //主要用于识别到当前模块内容为哪一部分
    public static final String modular = "Business";
    //此处属性与数据库表保持一致
    public static final String mysqlTableName = "Business";
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
    // 赞助商 对象的唯一ID属性
    private Integer id;
    // 赞助商 对象的数据变更时间属性
    private String time;
    // 赞助商 对象的赞助商标题属性
    private String title;
    // 赞助商 对象的赞助商内容属性
    private String text;
}
