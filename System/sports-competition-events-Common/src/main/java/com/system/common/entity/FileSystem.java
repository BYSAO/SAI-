package com.system.common.entity;


import com.system.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.OutputStream;

//文件
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileSystem extends CommonEntity {

    public static final String modular = "FileSystem";
    public static final String mysqlTableName = "FileSystem";
    public static final String serviceModular = "system-provider";
    public static final String PAYMENT_URL = "/" + serviceModular + "/" + modular;
    private Integer id;
    //路径位置
    private String path;
    //类型
    private String type;
    //所属的模块
    private String relevancy;
    //原始文件名称
    private String rwaName;
    //下载文件名称
    private String downName;
    //系统文件名称
    private String systemName;
    private String searchParamWeb;
    private OutputStream outputStream;
    private String saveModular;

}
