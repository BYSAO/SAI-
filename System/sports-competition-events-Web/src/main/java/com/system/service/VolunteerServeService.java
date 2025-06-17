package com.system.service;


import com.system.common.entity.VolunteerServe;
import com.system.provider.restTemplate.VolunteerServePService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerServeService {
    @Autowired
    private VolunteerServePService VolunteerServeDao;


    //查询所有内容
    public List<VolunteerServe> getAll(VolunteerServe t) {
        List<VolunteerServe> allT = new ArrayList<>();
        try {
            List<VolunteerServe> allSearch = VolunteerServeDao.getAll(t);
            for (VolunteerServe all : allSearch) {
                VolunteerServe search = new VolunteerServe();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<VolunteerServe> getAll2Page(VolunteerServe t) {
        List<VolunteerServe> allT = new ArrayList<>();
        try {
            List<VolunteerServe> allSearch = VolunteerServeDao.getAll2Page(t);
            for (VolunteerServe all : allSearch) {
                VolunteerServe search = new VolunteerServe();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(VolunteerServe t) {
        return VolunteerServeDao.count(t);
    }

    //获取单条数据内容
    public VolunteerServe get(VolunteerServe t) {
        VolunteerServe tSearch = null;
        try {
            tSearch = VolunteerServeDao.get(t);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public VolunteerServe add(VolunteerServe t) {
        try {
            VolunteerServe add = VolunteerServeDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<VolunteerServe> t) {
        String isSuccess = "false";
        try {
            for (VolunteerServe o : t) {
                final VolunteerServe add = VolunteerServeDao.add(o);
            }
            isSuccess = "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
        return isSuccess;
    }

    //实现数据删除内容
    public String del(VolunteerServe t) {
        String isSuccess = "false";
        try {
            isSuccess = VolunteerServeDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(VolunteerServe t) {
        try {
            String isSuccess = VolunteerServeDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
