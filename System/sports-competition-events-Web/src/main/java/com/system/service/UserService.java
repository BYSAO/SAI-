package com.system.service;


import com.system.common.entity.User;
import com.system.provider.restTemplate.UserPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserPService UserDao;


    //查询所有内容
    public List<User> getAll(User t) {
        List<User> allT = new ArrayList<>();
        try {
            List<User> allSearch = UserDao.getAll(t);
            for (User all : allSearch) {
                User search = new User();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<User> getAll2Page(User t) {
        List<User> allT = new ArrayList<>();
        try {
            List<User> allSearch = UserDao.getAll2Page(t);
            for (User all : allSearch) {
                User search = new User();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(User t) {
        return UserDao.count(t);
    }

    //获取单条数据内容
    public User get(User t) {
        User tSearch = null;
        try {
            tSearch = UserDao.get(t);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public User add(User t) {
        try {
            User add = UserDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<User> t) {
        String isSuccess = "false";
        try {
            for (User o : t) {
                final User add = UserDao.add(o);
            }
            isSuccess = "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
        return isSuccess;
    }

    //实现数据删除内容
    public String del(User t) {
        String isSuccess = "false";
        try {
            isSuccess = UserDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(User t) {
        try {
            String isSuccess = UserDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
