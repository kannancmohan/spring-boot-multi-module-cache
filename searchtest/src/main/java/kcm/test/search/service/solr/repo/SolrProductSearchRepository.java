package kcm.test.search.service.solr.repo;

import kcm.test.search.service.core.model.Product;
import kcm.test.search.service.core.repo.ProductSearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import kcm.test.search.service.solr.model.SolrProduct;


/*@Repository
@Qualifier("productSearchRepository")*/
public class SolrProductSearchRepository extends SimpleSolrRepository<SolrProduct, String> implements ProductSearchRepository<SolrProduct, String> {

    public SolrProductSearchRepository(SolrOperations solrOperations, Class<SolrProduct> entityClass) {
        super(solrOperations, entityClass);
    }


    public Page<Product> findByKey(String key) {
        return null;
    }
}
