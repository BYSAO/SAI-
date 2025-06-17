package com.system;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//Web
@Component
public class MyCommandRunner implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) {

        try {
            Runtime.getRuntime().exec("cmd /c start " + "http://localhost:" + environment.getProperty("server.port"));  // 可以指定自己的路径
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("浏览器打开页面异常");
        }
    }

}
