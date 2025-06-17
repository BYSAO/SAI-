package com.system.provider.restTemplate;

import com.system.common.entity.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ProjectPService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<Project> getAll(Project t) {
        String searchUrl = gatewayUrl + Project.PAYMENT_URL;
        Project[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, Project[].class);
        List<Project> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<Project> getAll2Page(Project t) {
        String searchUrl = gatewayUrl + Project.PAYMENT_URL;
        Project[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, Project[].class);
        List<Project> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(Project t) {
        String searchUrl = gatewayUrl + Project.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public Project get(Project t) {
        String searchUrl = gatewayUrl + Project.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, Project.class);
    }

    //增加
    public Project add(Project t) {
        String searchUrl = gatewayUrl + Project.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, Project.class);
    }

    //删除
    public String del(Project t) {
        String searchUrl = gatewayUrl + Project.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(Project t) {
        String searchUrl = gatewayUrl + Project.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
