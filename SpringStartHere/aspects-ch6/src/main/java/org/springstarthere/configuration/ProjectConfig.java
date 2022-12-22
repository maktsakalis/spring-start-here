package org.springstarthere.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springstarthere.aspects.LoggingAspect;
import org.springstarthere.aspects.SecurityAspect;

@Configuration
@ComponentScan(basePackages = "org.springstarthere.services")
@EnableAspectJAutoProxy
public class ProjectConfig {

  // @Bean
  // public LoggingAspect loggingAspect(){
  // return new LoggingAspect();
  // }

  @Bean
  public LoggingAspect loggingAspectWithAnnotation() {
    return new LoggingAspect();
  }

  @Bean
  public SecurityAspect securityAspect() {
    return new SecurityAspect();
  }

}
