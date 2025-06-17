package com.system.provider.restTemplate;

import com.system.common.entity.Achievement;
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
public class AchievementPService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<Achievement> getAll(Achievement t) {
        String searchUrl = gatewayUrl + Achievement.PAYMENT_URL;
        Achievement[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, Achievement[].class);
        List<Achievement> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<Achievement> getAll2Page(Achievement t) {
        String searchUrl = gatewayUrl + Achievement.PAYMENT_URL;
        Achievement[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, Achievement[].class);
        List<Achievement> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(Achievement t) {
        String searchUrl = gatewayUrl + Achievement.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public Achievement get(Achievement t) {
        String searchUrl = gatewayUrl + Achievement.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, Achievement.class);
    }

    //增加
    public Achievement add(Achievement t) {
        String searchUrl = gatewayUrl + Achievement.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, Achievement.class);
    }

    //删除
    public String del(Achievement t) {
        String searchUrl = gatewayUrl + Achievement.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(Achievement t) {
        String searchUrl = gatewayUrl + Achievement.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
