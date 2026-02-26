package com.example.artists.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.example.artists")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer configur(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
