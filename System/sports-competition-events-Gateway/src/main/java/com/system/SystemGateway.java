package com.system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//网关 Gateway

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SystemGateway {
    public static void main(String[] args) {
        SpringApplication.run(SystemGateway.class, args);
    }
}
