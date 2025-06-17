package com.system.dao;

import com.system.common.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //查询全部
    List<User> getAll(User t);

    //查询全部
    List<User> getAll2Page(User t);

    //查询总数
    int count(User t);

    //查询
    User get(User t);

    //增加
    void add(User t);

    //批量新增
    int addS(List<User> t);

    //删除
    int del(User t);

    //修改
    int update(User t);
}
