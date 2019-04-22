package com.learning.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JavaAndDesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaAndDesignPatternApplication.class, args);
    }
}
