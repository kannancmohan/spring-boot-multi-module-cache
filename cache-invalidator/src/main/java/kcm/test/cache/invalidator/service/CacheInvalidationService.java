package kcm.test.cache.invalidator.service;

public interface CacheInvalidationService {
    void invalidateAllCache();
    void invalidateCacheByCacheNameAndKey(String cacheName, String cacheId);
    void invalidateCacheByCacheName(String cacheName);
}
