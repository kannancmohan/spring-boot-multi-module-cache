package kcm.test.search.service.elastic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kcm.test.search.service.elastic")
@Conditional(ElasticSearchModuleCondition.class)
public class ElasticSearchModuleConfig {

}
