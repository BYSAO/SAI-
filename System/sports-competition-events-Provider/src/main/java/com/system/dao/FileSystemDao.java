package com.system.dao;

import com.system.common.entity.FileSystem;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FileSystemDao {
    //查询全部
    List<FileSystem> getAll(FileSystem t);

    //查询全部
    List<FileSystem> getAll2Page(FileSystem t);

    //查询总数
    int count(FileSystem t);

    //查询
    FileSystem get(FileSystem t);

    //增加
    void add(FileSystem t);

    //批量新增
    int addS(List<FileSystem> t);

    //删除
    int del(FileSystem t);

    //修改
    int update(FileSystem t);
}

