package test.boot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "caching")
public class CacheConfigurationProperties {

    private Map<String, CacheSpec> specs = new HashMap<>();

    public Map<String, CacheSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(Map<String, CacheSpec> specs) {
        this.specs = specs;
    }
}
