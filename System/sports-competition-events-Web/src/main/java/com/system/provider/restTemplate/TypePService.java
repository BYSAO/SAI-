package com.system.provider.restTemplate;

import com.system.common.entity.Type;
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
public class TypePService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;
    @Value("${gateway-config.url}")
    private String gatewayUrl;

    //查询全部
    public List<Type> getAll(Type t) {
        String searchUrl = gatewayUrl + Type.PAYMENT_URL;
        Type[] listArr = restTemplate.postForObject(searchUrl + "/getAll", t, Type[].class);
        List<Type> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //分页查询
    public List<Type> getAll2Page(Type t) {
        String searchUrl = gatewayUrl + Type.PAYMENT_URL;
        Type[] listArr = restTemplate.postForObject(searchUrl + "/getAll2Page", t, Type[].class);
        List<Type> returnList = Arrays.asList(listArr);
        return returnList;
    }

    //查询总数
    public int count(Type t) {
        String searchUrl = gatewayUrl + Type.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/count", t, Integer.class);
    }

    //查询
    public Type get(Type t) {
        String searchUrl = gatewayUrl + Type.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/get", t, Type.class);
    }

    //增加
    public Type add(Type t) {
        String searchUrl = gatewayUrl + Type.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/add", t, Type.class);
    }

    //删除
    public String del(Type t) {
        String searchUrl = gatewayUrl + Type.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/del", t, String.class);
    }

    //修改
    public String update(Type t) {
        String searchUrl = gatewayUrl + Type.PAYMENT_URL;
        return restTemplate.postForObject(searchUrl + "/update", t, String.class);
    }
}
