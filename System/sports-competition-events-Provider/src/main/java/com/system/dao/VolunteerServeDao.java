package com.system.dao;

import com.system.common.entity.VolunteerServe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerServeDao {
    //查询全部
    List<VolunteerServe> getAll(VolunteerServe t);

    //查询全部
    List<VolunteerServe> getAll2Page(VolunteerServe t);

    //查询总数
    int count(VolunteerServe t);

    //查询
    VolunteerServe get(VolunteerServe t);

    //增加
    void add(VolunteerServe t);

    //批量新增
    int addS(List<VolunteerServe> t);

    //删除
    int del(VolunteerServe t);

    //修改
    int update(VolunteerServe t);
}
