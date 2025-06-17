package com.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//公共父类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonEntity {
    private Integer id;
    //页数
    private Integer page = 1;
    //条数
    private Integer rows = 10;
    private Integer isDel;
    private String time;

}
