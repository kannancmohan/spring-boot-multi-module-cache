package test.boot;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import test.boot.conf.CacheConfigurationProperties;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
//@EnableCaching
@EnableConfigurationProperties(CacheConfigurationProperties.class)
public class ApplicationCacheConfig extends CachingConfigurerSupport {
    @Bean
    public CacheManager cacheManager(CacheConfigurationProperties cacheProperties) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        if (!CollectionUtils.isEmpty(cacheProperties.getSpecs())) {
            System.out.println(">>>Creating cache manger with cache(s)");
            List<ConcurrentMapCache> cacheList = cacheProperties.getSpecs().entrySet().stream().map(spec -> new ConcurrentMapCache(spec.getKey())).collect(Collectors.toList());
            cacheManager.setCaches(cacheList);
        }
        return cacheManager;
    }

}
