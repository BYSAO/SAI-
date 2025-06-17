package com.system.provider.restTemplate;

import com.system.common.entity.Information;
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
public class InformationPService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<Information> getAll(Information t) {
        String searchUrl = gatewayUrl + Information.PAYMENT_URL;
        Information[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, Information[].class);
        List<Information> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<Information> getAll2Page(Information t) {
        String searchUrl = gatewayUrl + Information.PAYMENT_URL;
        Information[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, Information[].class);
        List<Information> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(Information t) {
        String searchUrl = gatewayUrl + Information.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public Information get(Information t) {
        String searchUrl = gatewayUrl + Information.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, Information.class);
    }

    //增加
    public Information add(Information t) {
        String searchUrl = gatewayUrl + Information.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, Information.class);
    }

    //删除
    public String del(Information t) {
        String searchUrl = gatewayUrl + Information.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(Information t) {
        String searchUrl = gatewayUrl + Information.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
