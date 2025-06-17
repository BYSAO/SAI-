package com.system.dao;

import com.system.common.entity.Information;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationDao {
    //查询全部
    List<Information> getAll(Information t);

    //查询全部
    List<Information> getAll2Page(Information t);

    //查询总数
    int count(Information t);

    //查询
    Information get(Information t);

    //增加
    void add(Information t);

    //批量新增
    int addS(List<Information> t);

    //删除
    int del(Information t);

    //修改
    int update(Information t);
}
