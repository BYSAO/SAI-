package com.system.provider.feign;


import com.system.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//system-gateway 是 网关服务的application name
@FeignClient("system-gateway")
public interface UserFeignService {


    @RequestMapping("/User/getAll")
    List<User> getAll(@RequestBody User User);


    @RequestMapping("/User/getAll2Page")
    List<User> getAll2Page(@RequestBody User User);


    @RequestMapping("/User/count")
    Integer count(@RequestBody User User);


    @RequestMapping("/User/get")
    User get(@RequestBody User User);


    @RequestMapping("/User/add")
    Integer add(@RequestBody User User);


    @RequestMapping("/User/addS")
    Integer addS(@RequestBody List<User> t);


    @RequestMapping("/User/addIncrease")
    User addIncrease(@RequestBody User User);


    @RequestMapping("/User/del")
    Integer del(@RequestBody User User);


    @RequestMapping("/User/update")
    Integer update(@RequestBody User User);
}
