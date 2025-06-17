package com.system.dao;

import com.system.common.entity.VolunteerServeDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerServeDetailsDao {
    //查询全部
    List<VolunteerServeDetails> getAll(VolunteerServeDetails t);

    //查询全部
    List<VolunteerServeDetails> getAll2Page(VolunteerServeDetails t);

    //查询总数
    int count(VolunteerServeDetails t);

    //查询
    VolunteerServeDetails get(VolunteerServeDetails t);

    //增加
    void add(VolunteerServeDetails t);

    //批量新增
    int addS(List<VolunteerServeDetails> t);

    //删除
    int del(VolunteerServeDetails t);

    //修改
    int update(VolunteerServeDetails t);
}
