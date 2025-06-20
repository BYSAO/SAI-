package com.system.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//关闭Security 权限认证
public class CloseSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.csrf().disable();
        //配置不需要登陆验证
        http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
        http.headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();
    }

}
