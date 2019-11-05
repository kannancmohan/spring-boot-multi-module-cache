package test.boot.config.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import test.boot.config.cache.CacheConfigurationProperties;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableConfigurationProperties(CacheConfigurationProperties.class)
@ConditionalOnProperty(name = "cache.adapter", havingValue = "simple")
public class SimpleCacheConfig extends CachingConfigurerSupport {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleCacheConfig.class);

    @Bean
    public CacheManager cacheManager(CacheConfigurationProperties cacheProperties) {
        LOG.info("*****Creating SimpleCacheManager*****");
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        if (!CollectionUtils.isEmpty(cacheProperties.getSpecs())) {
            List<ConcurrentMapCache> cacheList = cacheProperties.getSpecs().entrySet().stream().map(spec -> {
                LOG.info("Configuring CacheName [" + spec.getKey() + "]");
                return new ConcurrentMapCache(spec.getKey());
            }).collect(Collectors.toList());
            cacheManager.setCaches(cacheList);
        }
        return cacheManager;
    }
}
