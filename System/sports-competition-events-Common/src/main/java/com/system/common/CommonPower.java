package com.system.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum CommonPower {
    ADMIN("管理员", "admin"),
    VOLUNTEER("志愿者", "volunteer"),
    VARCHAR("运动员", "user");


    //数据库类型
    private final String powerTitle;
    //程序类型
    private final String powerCode;

    // 构造方法
    CommonPower(String powerTitle, String powerCode) {
        this.powerTitle = powerTitle;
        this.powerCode = powerCode;
    }

    public static CommonPower getEnumPower(String powerTitle) {
        //默认值
        CommonPower r = VARCHAR;
        for (CommonPower enumProject : CommonPower.values()) {
            if (enumProject.getPowerTitle().equals(powerTitle)) {
                r = enumProject;
                break;
            }
        }
        return r;
    }

    //转为数据 枚举对象数据转换为list map结构
    public static List<Map<String, String>> toList() {
        List<Map<String, String>> list = new ArrayList<>();
        for (CommonPower item : CommonPower.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("powerTitle", item.getPowerTitle());
            map.put("powerCode", item.getPowerCode());
            list.add(map);
        }
        return list;
    }

    public String getPowerTitle() {
        return powerTitle;
    }

    public String getPowerCode() {
        return powerCode;
    }

}
