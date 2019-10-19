package kcm.test.some.conf;

import org.springframework.context.annotation.*;

@Conditional(SomeServiceModuleCacheCondition.class)
@Configuration
@PropertySource("classpath:some-service-module-cache-config.properties")
@ImportResource("classpath:some-service-module-spring-cache.xml")
public class SomeServiceModuleCacheConfig {

}
