package com.system;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//服务（Other）

@SpringBootApplication
@MapperScan("com.system.dao")
public class SystemProvider {
    public static void main(String[] args) {
        SpringApplication.run(SystemProvider.class, args);
    }
}
