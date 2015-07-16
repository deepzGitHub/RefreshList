package config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("config")
public class InnerConfig {

    @Bean
    @RefreshScope
    public RefreshListConfig refreshListConfig() {
        return new RefreshListConfig();
    }
}
