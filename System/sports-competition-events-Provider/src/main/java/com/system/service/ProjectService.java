package com.system.service;

import com.system.common.entity.Project;
import com.system.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao ProjectDao;

    //查询所有内容
    public List<Project> getAll(Project t) {
        List<Project> allT = new ArrayList<>();
        try {
            allT = ProjectDao.getAll(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Project> getAll2Page(Project t) {
        List<Project> allT = new ArrayList<>();
        try {
            allT = ProjectDao.getAll2Page(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(Project t) {
        return ProjectDao.count(t);
    }

    //获取单条数据内容
    public Project get(Project t) {
        Project tSearch = null;
        try {
            tSearch = ProjectDao.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Project add(Project t) {
        try {
            ProjectDao.add(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Project> t) {
        String isSuccess = "false";
        try {
            int resultNum = ProjectDao.addS(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
        return isSuccess;
    }

    //实现数据删除内容
    public String del(Project t) {
        String isSuccess = "false";
        try {
            int resultNum = ProjectDao.del(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Project t) {
        String isSuccess = "false";
        try {
            int resultNum = ProjectDao.update(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
        return isSuccess;
    }
}
