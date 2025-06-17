package com.system.provider.restTemplate;

import com.system.common.entity.Business;
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
public class BusinessPService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<Business> getAll(Business t) {
        String searchUrl = gatewayUrl + Business.PAYMENT_URL;
        Business[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, Business[].class);
        List<Business> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<Business> getAll2Page(Business t) {
        String searchUrl = gatewayUrl + Business.PAYMENT_URL;
        Business[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, Business[].class);
        List<Business> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(Business t) {
        String searchUrl = gatewayUrl + Business.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public Business get(Business t) {
        String searchUrl = gatewayUrl + Business.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, Business.class);
    }

    //增加
    public Business add(Business t) {
        String searchUrl = gatewayUrl + Business.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, Business.class);
    }

    //删除
    public String del(Business t) {
        String searchUrl = gatewayUrl + Business.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(Business t) {
        String searchUrl = gatewayUrl + Business.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
