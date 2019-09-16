package com.example.springbootquartzdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootQuartzDemoApplication extends SpringBootServletInitializer {

    @Override //为了打包springboot项目
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootQuartzDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootQuartzDemoApplication.class, args);
    }

}
