package kcm.test.search.service.solr.conf;


import kcm.test.search.service.core.repo.ProductSearchRepository;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import kcm.test.search.service.solr.model.SolrProduct;
import kcm.test.search.service.solr.repo.SolrProductSearchRepository;

@Configuration
@EnableSolrRepositories(basePackages = {"test.service.solr.repo"}, schemaCreationSupport = true)
public class SolrConfig {

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder().withBaseSolrUrl("http://localhost:8983/solr").build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }

    @Bean
    public ProductSearchRepository productSearchRepository(SolrTemplate template){
        return new SolrProductSearchRepository(template, SolrProduct.class);
    }
}
