package com.system.provider.restTemplate;

import com.system.common.entity.FileSystem;
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
public class FileSystemPService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;

    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<FileSystem> getAll(FileSystem t) {
        String searchUrl = gatewayUrl + FileSystem.PAYMENT_URL;
        FileSystem[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, FileSystem[].class);
        List<FileSystem> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<FileSystem> getAll2Page(FileSystem t) {
        String searchUrl = gatewayUrl + FileSystem.PAYMENT_URL;
        FileSystem[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, FileSystem[].class);
        List<FileSystem> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(FileSystem t) {
        String searchUrl = gatewayUrl + FileSystem.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public FileSystem get(FileSystem t) {
        String searchUrl = gatewayUrl + FileSystem.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, FileSystem.class);
    }

    //增加
    public FileSystem add(FileSystem t) {
        String searchUrl = gatewayUrl + FileSystem.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, FileSystem.class);
    }


    //删除
    public String del(FileSystem t) {
        String searchUrl = gatewayUrl + FileSystem.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(FileSystem t) {
        String searchUrl = gatewayUrl + FileSystem.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }

}
