package kcm.test.search.service.solr.service;

import kcm.test.search.service.core.service.ProductSearchService;
import kcm.test.search.service.core.model.Product;
import kcm.test.search.service.core.repo.ProductSearchRepository;
import kcm.test.search.service.solr.model.SolrProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolrProductSearchService implements ProductSearchService {
    @Autowired
    @Qualifier("productSearchRepository")
    ProductSearchRepository<Product, String> productSearchRepository;

    public Product getTest() {
        /*SolrProduct product = new SolrProduct();
        product.setId("1234");
        product.setName("test name");
        productSearchRepository.save(product);*/
        Optional<Product> product1 = productSearchRepository.findById("1234");
        product1.ifPresent(p -> System.out.println("INSIDE getTest PRODUCT --> " + p));
        return product1.orElse(null);
    }
}
