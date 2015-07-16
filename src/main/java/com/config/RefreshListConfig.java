package com.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test.refreshlist")
public class RefreshListConfig {

    public List<String> colors;

    private String source;

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    @PostConstruct
    public void postConstruct() {

        if (colors != null) {
            System.out.println("Colors ---> " + colors);
        }
    }

    public String getClassName() {
        return RefreshListConfig.class.getName();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder("source = ");
        sb.append(this.source);
        sb.append(", colors = ");
        if(CollectionUtils.isNotEmpty(this.colors)) {
            sb.append(this.colors.toString());
        } else {
            sb.append("{}");
        }
        
        return sb.toString();
    }
}
