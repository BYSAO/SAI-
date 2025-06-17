package com.system.provider.restTemplate;

import com.system.common.entity.Analyse;
import com.system.common.entity.Analyse;
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
public class AnalysePService {
    @Autowired(required = false) // 这个可以解决idea报错
    @Qualifier("restTemplateGateway") // 表示根据名称来找bean
    private RestTemplate restTemplate;

    @Value("${gateway-config.url}")
    private String gatewayUrl;

    public List<Analyse> AnalyseItinerary(Analyse t) {
        String searchUrl = gatewayUrl + Analyse.PAYMENT_URL;
        Analyse[] listArr = restTemplate.postForObject(searchUrl + "/AnalyseItinerary", t, Analyse[].class);
        List<Analyse> returnList = Arrays.asList(listArr);
        return returnList;
    }

    public List<Analyse> AnalyseSum(Analyse t) {
        String searchUrl = gatewayUrl + Analyse.PAYMENT_URL;
        Analyse[] listArr = restTemplate.postForObject(searchUrl + "/AnalyseSum", t, Analyse[].class);
        List<Analyse> returnList = Arrays.asList(listArr);
        return returnList;
    }

}
