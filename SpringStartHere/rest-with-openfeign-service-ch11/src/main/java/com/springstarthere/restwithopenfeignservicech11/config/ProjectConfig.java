package com.springstarthere.restwithopenfeignservicech11.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.springstarthere.restwithopenfeignservicech11.proxy")
public class ProjectConfig {
}
