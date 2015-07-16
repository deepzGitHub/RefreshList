package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.InnerConfig;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"config", "demo"})
//@Import(InnerConfig.class) When Import is done List on RefreshScope bean is not getting updated, InnerConfig will be picked since the @ComponentScan is on that package (but even this has the same issue).
public class RefreshListApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefreshListApplication.class, args);
    }
  
}
