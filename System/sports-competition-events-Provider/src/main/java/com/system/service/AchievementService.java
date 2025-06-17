package com.system.service;

import com.system.common.entity.Achievement;
import com.system.dao.AchievementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchievementService {
    @Autowired
    private AchievementDao AchievementDao;

    //查询所有内容
    public List<Achievement> getAll(Achievement t) {
        List<Achievement> allT = new ArrayList<>();
        try {
            allT = AchievementDao.getAll(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Achievement> getAll2Page(Achievement t) {
        List<Achievement> allT = new ArrayList<>();
        try {
            allT = AchievementDao.getAll2Page(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(Achievement t) {
        return AchievementDao.count(t);
    }

    //获取单条数据内容
    public Achievement get(Achievement t) {
        Achievement tSearch = null;
        try {
            tSearch = AchievementDao.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Achievement add(Achievement t) {
        try {
            AchievementDao.add(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Achievement> t) {
        String isSuccess = "false";
        try {
            int resultNum = AchievementDao.addS(t);
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
    public String del(Achievement t) {
        String isSuccess = "false";
        try {
            int resultNum = AchievementDao.del(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Achievement t) {
        String isSuccess = "false";
        try {
            int resultNum = AchievementDao.update(t);
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
