package com.system.dao;

import com.system.common.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    //查询全部
    List<Notice> getAll(Notice t);

    //查询全部
    List<Notice> getAll2Page(Notice t);

    //查询总数
    int count(Notice t);

    //查询
    Notice get(Notice t);

    //增加
    void add(Notice t);

    //批量新增
    int addS(List<Notice> t);

    //删除
    int del(Notice t);

    //修改
    int update(Notice t);
}
