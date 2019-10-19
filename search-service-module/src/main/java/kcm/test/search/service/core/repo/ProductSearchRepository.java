package kcm.test.search.service.core.repo;

import kcm.test.search.service.core.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface ProductSearchRepository<T extends Product, String> extends CrudRepository<T, String> {
    //T getSS();

    @Cacheable("search-product")
    Page<Product> findByKey(String key);

}
