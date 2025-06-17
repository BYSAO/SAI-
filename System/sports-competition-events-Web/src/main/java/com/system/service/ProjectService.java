package com.system.service;

import com.system.common.entity.Type;
import com.system.provider.restTemplate.TypePService;
import com.system.service.TypeService;
import com.system.common.entity.FileSystem;
import com.system.service.FileSystemService;


import com.system.common.entity.Project;
import com.system.provider.restTemplate.ProjectPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectPService ProjectDao;
    @Autowired
    private TypePService TypeDao;
    @Autowired
    private TypeService TypeService;
    @Autowired
    private FileSystemService FileSystemService;


    //查询所有内容
    public List<Project> getAll(Project t) {
        List<Project> allT = new ArrayList<>();
        try {
            List<Project> allSearch = ProjectDao.getAll(t);
            for (Project all : allSearch) {
                Project search = new Project();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //分页查询内容
    public List<Project> getAll2Page(Project t) {
        List<Project> allT = new ArrayList<>();
        try {
            List<Project> allSearch = ProjectDao.getAll2Page(t);
            for (Project all : allSearch) {
                Project search = new Project();
                search.setId(all.getId());
                allT.add(get(search));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allT;
    }

    //统计指定条件总数
    public Integer count(Project t) {
        return ProjectDao.count(t);
    }

    //获取单条数据内容
    public Project get(Project t) {
        Project tSearch = null;
        try {
            tSearch = ProjectDao.get(t);
            if (null != tSearch && !StringUtils.isEmpty(tSearch.getType())) {
                final Type searchTypeObj = TypeService.get(Type.builder().id(tSearch.getType()).build());
                tSearch.setTypeObj(searchTypeObj);
            }


            //获取相关文件信息
            FileSystem fileSearchParam = new FileSystem();
            fileSearchParam.setRelevancy(String.valueOf(tSearch.getId()));
            fileSearchParam.setType(Project.modular);
            List<FileSystem> all = FileSystemService.getAll(fileSearchParam);
            if (all.size() > 0) {
                tSearch.setHasFile(true);
                tSearch.setFileList(all);
                tSearch.setFileListShow(all.get(0).getPath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSearch;
    }

    //实现数据添加内容
    public Project add(Project t) {
        try {
            Project add = ProjectDao.add(t);
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //实现数据批量添加内容
    public String addS(List<Project> t) {
        String isSuccess = "false";
        try {
            for (Project o : t) {
                final Project add = ProjectDao.add(o);
            }
            isSuccess = "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
        return isSuccess;
    }

    //实现数据删除内容
    public String del(Project t) {
        String isSuccess = "false";
        try {
            isSuccess = ProjectDao.del(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //实现数据的更新操作
    public String update(Project t) {
        try {
            String isSuccess = ProjectDao.update(t);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return "false-has-double";
        }
    }
}
