package com.system.provider.restTemplate;

import com.system.common.entity.VolunteerServeDetails;
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
public class VolunteerServeDetailsPService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<VolunteerServeDetails> getAll(VolunteerServeDetails t) {
        String searchUrl = gatewayUrl + VolunteerServeDetails.PAYMENT_URL;
        VolunteerServeDetails[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, VolunteerServeDetails[].class);
        List<VolunteerServeDetails> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<VolunteerServeDetails> getAll2Page(VolunteerServeDetails t) {
        String searchUrl = gatewayUrl + VolunteerServeDetails.PAYMENT_URL;
        VolunteerServeDetails[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, VolunteerServeDetails[].class);
        List<VolunteerServeDetails> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(VolunteerServeDetails t) {
        String searchUrl = gatewayUrl + VolunteerServeDetails.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public VolunteerServeDetails get(VolunteerServeDetails t) {
        String searchUrl = gatewayUrl + VolunteerServeDetails.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, VolunteerServeDetails.class);
    }

    //增加
    public VolunteerServeDetails add(VolunteerServeDetails t) {
        String searchUrl = gatewayUrl + VolunteerServeDetails.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, VolunteerServeDetails.class);
    }

    //删除
    public String del(VolunteerServeDetails t) {
        String searchUrl = gatewayUrl + VolunteerServeDetails.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(VolunteerServeDetails t) {
        String searchUrl = gatewayUrl + VolunteerServeDetails.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
