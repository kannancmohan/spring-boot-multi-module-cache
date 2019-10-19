package kcm.test.search.service.core.service;

import kcm.test.search.service.core.model.Product;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = {"product"})
public interface ProductSearchService {
    @Cacheable
    public Product getTest();
}
