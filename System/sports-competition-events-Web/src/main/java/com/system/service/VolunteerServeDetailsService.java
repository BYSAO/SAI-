package com.system.service;

import com.system.common.entity.User;
import com.system.provider.restTemplate.UserPService;
import com.system.service.UserService;
import com.system.common.entity.VolunteerServe;
import com.system.provider.restTemplate.VolunteerServePService;
import com.system.service.VolunteerServeService;


import com.system.common.entity.VolunteerServeDetails;
import com.system.provider.restTemplate.VolunteerServeDetailsPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerServeDetailsService {
    @Autowired
    private VolunteerServeDetailsPService VolunteerServeDetailsDao;
    @Autowired
    private UserPService UserDao;
    @Autowired
    private UserService UserService;
    @Autowired
    private VolunteerServePService VolunteerServeDao;
    @Autowired
    private VolunteerServeService VolunteerServeService;


    //查询所有内容
    public List<VolunteerServeDetails> getAll(VolunteerServeDetails t) {
        List<VolunteerServeDetails> allT = new ArrayList<>();
        try {
            List<VolunteerServeDetails> allSearch = VolunteerServeDetailsDao.getAll(t);
            for (VolunteerServeDetails all : allSearch) {
                VolunteerServeDetails search = new VolunteerServeDetails();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<VolunteerServeDetails> getAll2Page(VolunteerServeDetails t) {
        List<VolunteerServeDetails> allT = new ArrayList<>();
        try {
            List<VolunteerServeDetails> allSearch = VolunteerServeDetailsDao.getAll2Page(t);
            for (VolunteerServeDetails all : allSearch) {
                VolunteerServeDetails search = new VolunteerServeDetails();
                search.setId(all.getId());
                allT.add(get(search));
            }
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
            if (null != tSearch && !StringUtils.isEmpty(tSearch.getUser())) {
                final User searchUserObj = UserDao.get(User.builder().id(tSearch.getUser()).build());
                tSearch.setUserObj(searchUserObj);
            }
            if (null != tSearch && !StringUtils.isEmpty(tSearch.getVolunteerServe())) {
                final VolunteerServe searchVolunteerServeObj = VolunteerServeDao.get(VolunteerServe.builder().id(tSearch.getVolunteerServe()).build());
                tSearch.setVolunteerServeObj(searchVolunteerServeObj);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public VolunteerServeDetails add(VolunteerServeDetails t) {
        try {
            VolunteerServeDetails add = VolunteerServeDetailsDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<VolunteerServeDetails> t) {
        String isSuccess = "false";
        try {
            for (VolunteerServeDetails o : t) {
                final VolunteerServeDetails add = VolunteerServeDetailsDao.add(o);
            }
            isSuccess = "true";
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
            isSuccess = VolunteerServeDetailsDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(VolunteerServeDetails t) {
        try {
            String isSuccess = VolunteerServeDetailsDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
