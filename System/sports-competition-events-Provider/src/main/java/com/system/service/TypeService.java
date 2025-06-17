package com.system.service;

import com.system.common.entity.Type;
import com.system.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeDao TypeDao;

    //查询所有内容
    public List<Type> getAll(Type t) {
        List<Type> allT = new ArrayList<>();
        try {
            allT = TypeDao.getAll(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Type> getAll2Page(Type t) {
        List<Type> allT = new ArrayList<>();
        try {
            allT = TypeDao.getAll2Page(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(Type t) {
        return TypeDao.count(t);
    }

    //获取单条数据内容
    public Type get(Type t) {
        Type tSearch = null;
        try {
            tSearch = TypeDao.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Type add(Type t) {
        try {
            TypeDao.add(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Type> t) {
        String isSuccess = "false";
        try {
            int resultNum = TypeDao.addS(t);
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
    public String del(Type t) {
        String isSuccess = "false";
        try {
            int resultNum = TypeDao.del(t);
            if (resultNum > 0) {
                isSuccess = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Type t) {
        String isSuccess = "false";
        try {
            int resultNum = TypeDao.update(t);
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
