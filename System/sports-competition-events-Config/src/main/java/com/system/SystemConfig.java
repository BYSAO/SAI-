package com.system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;


//配置中心（Config）

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer
public class SystemConfig {
    public static void main(String[] args) {
        SpringApplication.run(SystemConfig.class, args);
        System.out.println("配置中心启动成功~");
    }
}
