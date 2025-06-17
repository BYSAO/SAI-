package com.system.service;


import com.system.common.entity.FileSystem;
import com.system.provider.restTemplate.FileSystemPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FileSystemService {
    @Autowired
    private FileSystemPService FileSystemDao;

    //查询所有内容
    public List<FileSystem> getAll(FileSystem t) {
        List<FileSystem> allT = new ArrayList<>();
        try {
            List<FileSystem> allSearch = FileSystemDao.getAll(t);
            for (FileSystem all : allSearch) {
                FileSystem search = new FileSystem();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<FileSystem> getAll2Page(FileSystem t) {
        List<FileSystem> allT = new ArrayList<>();
        try {
            List<FileSystem> allSearch = FileSystemDao.getAll2Page(t);
            for (FileSystem all : allSearch) {
                FileSystem search = new FileSystem();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }


    //统计指定条件总数
    public Integer count(FileSystem t) {
        return FileSystemDao.count(t);
    }


    //获取单条数据内容
    public FileSystem get(FileSystem t) {
        FileSystem tSearch = null;
        try {
            tSearch = FileSystemDao.get(t);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public FileSystem add(FileSystem t) {
        try {
            FileSystemDao.add(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //实现数据批量添加内容
    public String addS(List<FileSystem> t) {
        String isSuccess = "false";
        try {
            for (FileSystem o : t) {
                FileSystemDao.add(o);
            }

            isSuccess = "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
        return isSuccess;
    }


    //实现数据删除内容
    public String del(FileSystem t) {
        String isSuccess = "false";
        try {
            isSuccess = FileSystemDao.del(t);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(FileSystem t) {
        try {
            String isSuccess = FileSystemDao.update(t);

            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }

}
