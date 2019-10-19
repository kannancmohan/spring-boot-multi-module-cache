package kcm.test.search.service.elastic.conf;

import kcm.test.search.service.core.repo.ProductSearchRepository;
import kcm.test.search.service.elastic.repo.ElasticProductSearchRepository;
import kcm.test.search.service.solr.model.SolrProduct;
import kcm.test.search.service.solr.repo.SolrProductSearchRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.solr.core.SolrTemplate;

@Configuration
@EnableElasticsearchRepositories
public class ElasticConfig {

    @Bean
    public ProductSearchRepository productSearchRepository(){
        return new ElasticProductSearchRepository();
    }

}
