package com.system.dao;

import com.system.common.entity.Business;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessDao {
    //查询全部
    List<Business> getAll(Business t);

    //查询全部
    List<Business> getAll2Page(Business t);

    //查询总数
    int count(Business t);

    //查询
    Business get(Business t);

    //增加
    void add(Business t);

    //批量新增
    int addS(List<Business> t);

    //删除
    int del(Business t);

    //修改
    int update(Business t);
}
