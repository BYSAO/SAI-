package com.system.service;

import com.system.common.entity.User;
import com.system.provider.restTemplate.UserPService;
import com.system.service.UserService;
import com.system.common.entity.Project;
import com.system.provider.restTemplate.ProjectPService;
import com.system.service.ProjectService;


import com.system.common.entity.Achievement;
import com.system.provider.restTemplate.AchievementPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchievementService {
    @Autowired
    private AchievementPService AchievementDao;
    @Autowired
    private UserPService UserDao;
    @Autowired
    private UserService UserService;
    @Autowired
    private ProjectPService ProjectDao;
    @Autowired
    private ProjectService ProjectService;


    //查询所有内容
    public List<Achievement> getAll(Achievement t) {
        List<Achievement> allT = new ArrayList<>();
        try {
            List<Achievement> allSearch = AchievementDao.getAll(t);
            for (Achievement all : allSearch) {
                Achievement search = new Achievement();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Achievement> getAll2Page(Achievement t) {
        List<Achievement> allT = new ArrayList<>();
        try {
            List<Achievement> allSearch = AchievementDao.getAll2Page(t);
            for (Achievement all : allSearch) {
                Achievement search = new Achievement();
                search.setId(all.getId());
                allT.add(get(search));
            }
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
            if (null != tSearch && !StringUtils.isEmpty(tSearch.getUser())) {
                final User searchUserObj = UserDao.get(User.builder().id(tSearch.getUser()).build());
                tSearch.setUserObj(searchUserObj);
            }
            if (null != tSearch && !StringUtils.isEmpty(tSearch.getProject())) {
                final Project searchProjectObj = ProjectDao.get(Project.builder().id(tSearch.getProject()).build());
                tSearch.setProjectObj(searchProjectObj);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Achievement add(Achievement t) {
        try {
            Achievement add = AchievementDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Achievement> t) {
        String isSuccess = "false";
        try {
            for (Achievement o : t) {
                final Achievement add = AchievementDao.add(o);
            }
            isSuccess = "true";
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
            isSuccess = AchievementDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Achievement t) {
        try {
            String isSuccess = AchievementDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
