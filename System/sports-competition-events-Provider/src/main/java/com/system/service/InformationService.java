package com.system.service;

import com.system.common.entity.Information;
import com.system.dao.InformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationDao InformationDao;

    //查询所有内容
    public List<Information> getAll(Information t) {
        List<Information> allT = new ArrayList<>();
        try {
            allT = InformationDao.getAll(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Information> getAll2Page(Information t) {
        List<Information> allT = new ArrayList<>();
        try {
            allT = InformationDao.getAll2Page(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(Information t) {
        return InformationDao.count(t);
    }

    //获取单条数据内容
    public Information get(Information t) {
        Information tSearch = null;
        try {
            tSearch = InformationDao.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Information add(Information t) {
        try {
            InformationDao.add(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Information> t) {
        String isSuccess = "false";
        try {
            int resultNum = InformationDao.addS(t);
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
    public String del(Information t) {
        String isSuccess = "false";
        try {
            int resultNum = InformationDao.del(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Information t) {
        String isSuccess = "false";
        try {
            int resultNum = InformationDao.update(t);
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
