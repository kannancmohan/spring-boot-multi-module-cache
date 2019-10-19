package kcm.test.search.service.core.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Conditional(SearchCacheCondition.class)
@Configuration
@ComponentScan("kcm.test.search.service.core")
@PropertySource("classpath:search-cache-config.properties")
@EnableCaching
public class SearchCacheConfig {

    @Bean
    public String testBean(){
        System.out.println(">>> INSIDE SearchCacheConfig");
        return "testBean";
    }
}
