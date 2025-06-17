package com.system.dao;

import com.system.common.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {
    //查询全部
    List<Type> getAll(Type t);

    //查询全部
    List<Type> getAll2Page(Type t);

    //查询总数
    int count(Type t);

    //查询
    Type get(Type t);

    //增加
    void add(Type t);

    //批量新增
    int addS(List<Type> t);

    //删除
    int del(Type t);

    //修改
    int update(Type t);
}
