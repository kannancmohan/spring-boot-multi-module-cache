package test.boot.config.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "caching")
public class RedisCacheConfigurationProperties extends CacheConfigurationProperties {

    private long redisTimeoutInSeconds;
    private int redisPort;
    private String redisHost;

    public long getRedisTimeoutInSeconds() {
        return redisTimeoutInSeconds;
    }

    public void setRedisTimeoutInSeconds(long redisTimeoutInSeconds) {
        this.redisTimeoutInSeconds = redisTimeoutInSeconds;
    }

    public int getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(int redisPort) {
        this.redisPort = redisPort;
    }

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }
}
