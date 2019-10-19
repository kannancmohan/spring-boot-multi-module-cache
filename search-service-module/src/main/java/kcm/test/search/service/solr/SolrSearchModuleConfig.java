package kcm.test.search.service.solr;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kcm.test.search.service.solr")
@Conditional(SolrSearchModuleCondition.class)
public class SolrSearchModuleConfig {

}
