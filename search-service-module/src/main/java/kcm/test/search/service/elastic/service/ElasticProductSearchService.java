package kcm.test.search.service.elastic.service;

import kcm.test.search.service.core.service.ProductSearchService;
import kcm.test.search.service.core.model.Product;
import kcm.test.search.service.core.repo.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ElasticProductSearchService implements ProductSearchService {
    @Autowired
    @Qualifier("productSearchRepository")
    ProductSearchRepository<Product, String> productSearchRepository;

    @Override
    public Product getProduct(String id) {
        Optional<Product> product1 = productSearchRepository.findById(id);
        product1.ifPresent(p -> System.out.println("Invoked original ProductSearchService::getTest method --> " + p));
        return product1.orElse(null);
    }
}
