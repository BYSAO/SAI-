package com.system.service;

import com.system.common.entity.Business;
import com.system.dao.BusinessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {
    @Autowired
    private BusinessDao BusinessDao;

    //查询所有内容
    public List<Business> getAll(Business t) {
        List<Business> allT = new ArrayList<>();
        try {
            allT = BusinessDao.getAll(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Business> getAll2Page(Business t) {
        List<Business> allT = new ArrayList<>();
        try {
            allT = BusinessDao.getAll2Page(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(Business t) {
        return BusinessDao.count(t);
    }

    //获取单条数据内容
    public Business get(Business t) {
        Business tSearch = null;
        try {
            tSearch = BusinessDao.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Business add(Business t) {
        try {
            BusinessDao.add(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Business> t) {
        String isSuccess = "false";
        try {
            int resultNum = BusinessDao.addS(t);
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
    public String del(Business t) {
        String isSuccess = "false";
        try {
            int resultNum = BusinessDao.del(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Business t) {
        String isSuccess = "false";
        try {
            int resultNum = BusinessDao.update(t);
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
