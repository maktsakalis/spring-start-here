package com.springstarthere.loginch9.config;

import com.springstarthere.loginch9.model.LoginProcessor;
import com.springstarthere.loginch9.services.LoggedUserManagementService;
import com.springstarthere.loginch9.services.LoginCountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springstarthere.loginch9")
public class ProjectConfig {

    @Bean
    public LoggedUserManagementService loggedUserManagementService1(){
        return new LoggedUserManagementService();
    }

    @Bean
    public LoginCountService loginCountService1(){
        return new LoginCountService();
    }

    @Bean
    public LoginProcessor loginProcessor1(){
        return new LoginProcessor(loggedUserManagementService1(),loginCountService1());
    }

    @Bean
    public LoginProcessor loginProcessor2(){
        return new LoginProcessor(loggedUserManagementService1(),loginCountService1());
    }
}
