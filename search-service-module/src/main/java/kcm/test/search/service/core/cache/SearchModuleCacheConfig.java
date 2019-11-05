package kcm.test.search.service.core.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Conditional(SearchCacheCondition.class)
@Configuration
@ComponentScan("kcm.test.search.service.core")
@PropertySource("classpath:search-service-cache-config.properties")
@ImportResource("classpath:search-service-module-spring-cache.xml")
public class SearchModuleCacheConfig {

}
