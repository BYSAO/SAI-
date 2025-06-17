package com.system.dao;

import com.system.common.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao {
    //查询全部
    List<Project> getAll(Project t);

    //查询全部
    List<Project> getAll2Page(Project t);

    //查询总数
    int count(Project t);

    //查询
    Project get(Project t);

    //增加
    void add(Project t);

    //批量新增
    int addS(List<Project> t);

    //删除
    int del(Project t);

    //修改
    int update(Project t);
}
