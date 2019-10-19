package kcm.test.some.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("kcm.test.some.service")
public class SomeServiceModuleConfig {
}
