package com.system.service;


import com.system.common.entity.Notice;
import com.system.provider.restTemplate.NoticePService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticePService NoticeDao;


    //查询所有内容
    public List<Notice> getAll(Notice t) {
        List<Notice> allT = new ArrayList<>();
        try {
            List<Notice> allSearch = NoticeDao.getAll(t);
            for (Notice all : allSearch) {
                Notice search = new Notice();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Notice> getAll2Page(Notice t) {
        List<Notice> allT = new ArrayList<>();
        try {
            List<Notice> allSearch = NoticeDao.getAll2Page(t);
            for (Notice all : allSearch) {
                Notice search = new Notice();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(Notice t) {
        return NoticeDao.count(t);
    }

    //获取单条数据内容
    public Notice get(Notice t) {
        Notice tSearch = null;
        try {
            tSearch = NoticeDao.get(t);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Notice add(Notice t) {
        try {
            Notice add = NoticeDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Notice> t) {
        String isSuccess = "false";
        try {
            for (Notice o : t) {
                final Notice add = NoticeDao.add(o);
            }
            isSuccess = "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
        return isSuccess;
    }

    //实现数据删除内容
    public String del(Notice t) {
        String isSuccess = "false";
        try {
            isSuccess = NoticeDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Notice t) {
        try {
            String isSuccess = NoticeDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
