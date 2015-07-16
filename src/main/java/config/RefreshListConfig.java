package config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;

@ConfigurationProperties(prefix="test.refreshlist")
public class RefreshListConfig {
    
    public List<String> colors;
    
    @Autowired
    private Environment env;

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    @PostConstruct
    public void postConstruct() {
        
        if(colors != null) {
            System.out.println("Colors ---> "+colors);
        }
    }

}
