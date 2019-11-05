package test.boot.config.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(RedisCacheConfigurationProperties.class)
@ConditionalOnProperty(name = "cache.adapter", havingValue = "redis")
public class RedisCacheConfig extends CachingConfigurerSupport {

    private static final Logger LOG = LoggerFactory.getLogger(RedisCacheConfig.class);


    @Bean
    public LettuceConnectionFactory redisConnectionFactory(RedisCacheConfigurationProperties properties) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(properties.getRedisHost());
        redisStandaloneConfiguration.setPort(properties.getRedisPort());
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory, RedisCacheConfigurationProperties properties) {
        LOG.info("*****Creating RedisCacheManager*****");
        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
        for (Map.Entry<String, CacheSpec> cacheSpecEntry : properties.getSpecs().entrySet()) {
            cacheConfigurations.put(cacheSpecEntry.getKey(), createCacheConfiguration(cacheSpecEntry.getValue().getTimeout()));
            LOG.info("Configuring CacheName [" + cacheSpecEntry.getKey() + "]");
        }
        //return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(cacheConfiguration(properties)).withInitialCacheConfigurations(cacheConfigurations).build();
        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(createDefaultConfiguration(properties)).withInitialCacheConfigurations(cacheConfigurations).build();
    }

    //@Bean("cacheConfiguration")
    public RedisCacheConfiguration createDefaultConfiguration(RedisCacheConfigurationProperties properties) {
        return createCacheConfiguration(properties.getRedisTimeoutInSeconds());
    }

    private static RedisCacheConfiguration createCacheConfiguration(long timeoutInSeconds) {
        return RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues().entryTtl(Duration.ofSeconds(timeoutInSeconds));
    }
}
