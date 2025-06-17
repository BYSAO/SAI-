package com.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//SpringCloudConfig
////配置文件自动刷新
@RefreshScope
@RestController
@RequestMapping("/SystemConfig")
public class SystemConfig {

    @Value("${mysql-config.url}")
    private String word;

    //获取配置
    @RequestMapping("/value")
    @ResponseBody
    public String update() {
        return word;
    }

}
//@Configuration
//public class MessageQueueConfig {
//
//    @Bean
//    public Queue myQueue() {
//        return new Queue("myQueue");
//    }
//
//    // 如果使用 RabbitMQ，可能还需要配置 ConnectionFactory 等
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
//        connectionFactory.setPort(5672);
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        return connectionFactory;
//    }
//}
