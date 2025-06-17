package com.system.provider.restTemplate;

import com.system.common.entity.User;
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
public class UserPService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<User> getAll(User t) {
        String searchUrl = gatewayUrl + User.PAYMENT_URL;
        User[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, User[].class);
        List<User> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<User> getAll2Page(User t) {
        String searchUrl = gatewayUrl + User.PAYMENT_URL;
        User[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, User[].class);
        List<User> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(User t) {
        String searchUrl = gatewayUrl + User.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public User get(User t) {
        String searchUrl = gatewayUrl + User.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, User.class);
    }

    //增加
    public User add(User t) {
        String searchUrl = gatewayUrl + User.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, User.class);
    }

    //删除
    public String del(User t) {
        String searchUrl = gatewayUrl + User.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(User t) {
        String searchUrl = gatewayUrl + User.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
