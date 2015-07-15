package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import config.RefreshListConfig;

@Configuration
@EnableAutoConfiguration
@ComponentScan("demo")
@EnableConfigurationProperties(RefreshListConfig.class)
public class RefreshListApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefreshListApplication.class, args);
    }
}
