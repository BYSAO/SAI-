package com.system.provider.restTemplate;

import com.system.common.entity.Notice;
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
public class NoticePService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<Notice> getAll(Notice t) {
        String searchUrl = gatewayUrl + Notice.PAYMENT_URL;
        Notice[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, Notice[].class);
        List<Notice> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<Notice> getAll2Page(Notice t) {
        String searchUrl = gatewayUrl + Notice.PAYMENT_URL;
        Notice[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, Notice[].class);
        List<Notice> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(Notice t) {
        String searchUrl = gatewayUrl + Notice.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public Notice get(Notice t) {
        String searchUrl = gatewayUrl + Notice.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, Notice.class);
    }

    //增加
    public Notice add(Notice t) {
        String searchUrl = gatewayUrl + Notice.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, Notice.class);
    }

    //删除
    public String del(Notice t) {
        String searchUrl = gatewayUrl + Notice.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(Notice t) {
        String searchUrl = gatewayUrl + Notice.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
