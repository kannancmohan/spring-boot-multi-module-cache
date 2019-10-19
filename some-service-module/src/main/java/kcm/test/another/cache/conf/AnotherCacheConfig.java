package kcm.test.another.cache.conf;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Conditional(AnotherCacheCondition.class)
@Configuration
@PropertySource("classpath:another-cache-config.properties")
@ImportResource("classpath:another-module-cache.xml")
public class AnotherCacheConfig {

    @Bean
    public String testBean2(){
        System.out.println(">>> INSIDE AnotherCacheConfig");
        return "testBean";
    }

}
