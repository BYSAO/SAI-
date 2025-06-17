package com.system.service;


import com.system.common.entity.Information;
import com.system.provider.restTemplate.InformationPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationPService InformationDao;


    //查询所有内容
    public List<Information> getAll(Information t) {
        List<Information> allT = new ArrayList<>();
        try {
            List<Information> allSearch = InformationDao.getAll(t);
            for (Information all : allSearch) {
                Information search = new Information();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Information> getAll2Page(Information t) {
        List<Information> allT = new ArrayList<>();
        try {
            List<Information> allSearch = InformationDao.getAll2Page(t);
            for (Information all : allSearch) {
                Information search = new Information();
                search.setId(all.getId());
                allT.add(get(search));
            }
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
            Information add = InformationDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Information> t) {
        String isSuccess = "false";
        try {
            for (Information o : t) {
                final Information add = InformationDao.add(o);
            }
            isSuccess = "true";
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
            isSuccess = InformationDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Information t) {
        try {
            String isSuccess = InformationDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
