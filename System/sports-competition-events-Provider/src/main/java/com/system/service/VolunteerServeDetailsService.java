package com.system.service;

import com.system.common.entity.VolunteerServeDetails;
import com.system.dao.VolunteerServeDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerServeDetailsService {
    @Autowired
    private VolunteerServeDetailsDao VolunteerServeDetailsDao;

    //查询所有内容
    public List<VolunteerServeDetails> getAll(VolunteerServeDetails t) {
        List<VolunteerServeDetails> allT = new ArrayList<>();
        try {
            allT = VolunteerServeDetailsDao.getAll(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<VolunteerServeDetails> getAll2Page(VolunteerServeDetails t) {
        List<VolunteerServeDetails> allT = new ArrayList<>();
        try {
            allT = VolunteerServeDetailsDao.getAll2Page(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(VolunteerServeDetails t) {
        return VolunteerServeDetailsDao.count(t);
    }

    //获取单条数据内容
    public VolunteerServeDetails get(VolunteerServeDetails t) {
        VolunteerServeDetails tSearch = null;
        try {
            tSearch = VolunteerServeDetailsDao.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public VolunteerServeDetails add(VolunteerServeDetails t) {
        try {
            VolunteerServeDetailsDao.add(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<VolunteerServeDetails> t) {
        String isSuccess = "false";
        try {
            int resultNum = VolunteerServeDetailsDao.addS(t);
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
    public String del(VolunteerServeDetails t) {
        String isSuccess = "false";
        try {
            int resultNum = VolunteerServeDetailsDao.del(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(VolunteerServeDetails t) {
        String isSuccess = "false";
        try {
            int resultNum = VolunteerServeDetailsDao.update(t);
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
