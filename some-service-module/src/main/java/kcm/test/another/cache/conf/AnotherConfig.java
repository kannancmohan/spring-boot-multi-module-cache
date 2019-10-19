package kcm.test.another.cache.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("kcm.test.another.cache.service")
public class AnotherConfig {
}
