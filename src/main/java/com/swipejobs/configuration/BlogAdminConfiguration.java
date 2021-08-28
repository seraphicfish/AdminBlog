package com.swipejobs.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("service")
public class BlogAdminConfiguration {

    @Value("${blogUserUrl}")
    private String blogGetUserUrl;

    @Value("${blogPostUrl}")
    private String blogGetPostUrl;

    public String getBlogGetUserUrl() {
        return blogGetUserUrl;
    }

    public String getBlogGetPostUrl() {
        return blogGetPostUrl;
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
