package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.config.InnerConfig;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import(InnerConfig.class) 
public class RefreshListApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefreshListApplication.class, args);
    }
  
}
