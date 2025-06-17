package com.system.common.entity;


import com.system.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Analyse {
    public static final String modular = "Analyse";
    public static final String mysqlTableName = "Analyse";
    public static final String serviceModular = "system-provider";
    public static final String PAYMENT_URL = "/" + serviceModular + "/" + modular;
    private String id;
    private String filed;//主要用于聚类指定字段
    private String filed1;//用于另外一个字段的统计 ，如 sum（other）
    private String countNum;
    private String sumNum;
    private String tableName;
    private String user;
    private String where;

    public String getWhere() {
        return where;
    }

    /*
     * where  字段直接添加检索条件, ru ty __ 1 代表 ty = 1
     * */
    public void setWhere(String where) {
        final String replace = where.replace("__", "=");
        this.where = replace;
    }


}
