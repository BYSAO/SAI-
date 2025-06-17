package com.system.service;


import com.system.common.entity.Type;
import com.system.provider.restTemplate.TypePService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypePService TypeDao;


    //查询所有内容
    public List<Type> getAll(Type t) {
        List<Type> allT = new ArrayList<>();
        try {
            List<Type> allSearch = TypeDao.getAll(t);
            for (Type all : allSearch) {
                Type search = new Type();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Type> getAll2Page(Type t) {
        List<Type> allT = new ArrayList<>();
        try {
            List<Type> allSearch = TypeDao.getAll2Page(t);
            for (Type all : allSearch) {
                Type search = new Type();
                search.setId(all.getId());
                allT.add(get(search));
            }
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
            Type add = TypeDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Type> t) {
        String isSuccess = "false";
        try {
            for (Type o : t) {
                final Type add = TypeDao.add(o);
            }
            isSuccess = "true";
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
            isSuccess = TypeDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Type t) {
        try {
            String isSuccess = TypeDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
