package kcm.test.search.service.elastic.repo;

import kcm.test.search.service.core.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.support.SimpleElasticsearchRepository;
import org.springframework.stereotype.Repository;
import kcm.test.search.service.core.repo.ProductSearchRepository;
import kcm.test.search.service.elastic.model.ElasticProduct;

/*@Repository
@Qualifier("productSearchRepository1")*/
public class ElasticProductSearchRepository extends SimpleElasticsearchRepository<ElasticProduct, String> implements ProductSearchRepository<ElasticProduct, String> {
    public Page<Product> findByKey(String key) {
        return null;
    }
}
