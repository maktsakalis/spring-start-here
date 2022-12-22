package org.springstarthere.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.springstarthere.proxies", "org.springstarthere.repositories", "org.springstarthere.services" })
public class ProjectConfiguration {
}
