package kcm.test.cache.invalidator.service.impl;

import kcm.test.cache.invalidator.service.CacheInvalidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CacheInvalidationServiceImpl implements CacheInvalidationService {

    @Autowired
    private CacheManager cacheManager;


    public void invalidateAllCache() {
        cacheManager.getCacheNames().forEach(name -> Objects.requireNonNull(cacheManager.getCache(name)).clear());
    }

    @Override
    public void invalidateCacheByCacheName(String cacheName) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }

    public void invalidateCacheByCacheNameAndKey(String cacheName, String cacheId) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).evict(cacheId);
    }

}
