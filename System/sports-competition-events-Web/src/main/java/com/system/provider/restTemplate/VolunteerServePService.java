package com.system.provider.restTemplate;

import com.system.common.entity.VolunteerServe;
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
public class VolunteerServePService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<VolunteerServe> getAll(VolunteerServe t) {
        String searchUrl = gatewayUrl + VolunteerServe.PAYMENT_URL;
        VolunteerServe[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, VolunteerServe[].class);
        List<VolunteerServe> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<VolunteerServe> getAll2Page(VolunteerServe t) {
        String searchUrl = gatewayUrl + VolunteerServe.PAYMENT_URL;
        VolunteerServe[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, VolunteerServe[].class);
        List<VolunteerServe> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(VolunteerServe t) {
        String searchUrl = gatewayUrl + VolunteerServe.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public VolunteerServe get(VolunteerServe t) {
        String searchUrl = gatewayUrl + VolunteerServe.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, VolunteerServe.class);
    }

    //增加
    public VolunteerServe add(VolunteerServe t) {
        String searchUrl = gatewayUrl + VolunteerServe.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, VolunteerServe.class);
    }

    //删除
    public String del(VolunteerServe t) {
        String searchUrl = gatewayUrl + VolunteerServe.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(VolunteerServe t) {
        String searchUrl = gatewayUrl + VolunteerServe.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
