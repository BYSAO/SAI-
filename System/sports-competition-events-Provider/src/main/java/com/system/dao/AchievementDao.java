package com.system.dao;

import com.system.common.entity.Achievement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementDao {
    //查询全部
    List<Achievement> getAll(Achievement t);

    //查询全部
    List<Achievement> getAll2Page(Achievement t);

    //查询总数
    int count(Achievement t);

    //查询
    Achievement get(Achievement t);

    //增加
    void add(Achievement t);

    //批量新增
    int addS(List<Achievement> t);

    //删除
    int del(Achievement t);

    //修改
    int update(Achievement t);
}
