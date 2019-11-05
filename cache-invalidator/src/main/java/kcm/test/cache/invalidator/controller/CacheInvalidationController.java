package kcm.test.cache.invalidator.controller;

import kcm.test.cache.invalidator.service.CacheInvalidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CacheInvalidationController {

    private static final Logger LOG = LoggerFactory.getLogger(CacheInvalidationController.class);

    private final CacheInvalidationService cacheInvalidationService;

    public CacheInvalidationController(CacheInvalidationService cacheInvalidationService) {
        this.cacheInvalidationService = cacheInvalidationService;
    }

    @RequestMapping(value = "/invalidateAllCache", method = RequestMethod.GET)
    @ResponseBody
    public String invalidateAllCache() {
        cacheInvalidationService.invalidateAllCache();
        return "Success";
    }

    @RequestMapping(value = "/invalidateCache/{cacheName}", method = RequestMethod.GET)
    @ResponseBody
    public String invalidateCacheByCacheName(@PathVariable String cacheName) {
        LOG.info("Invalidating cache with cacheName:" + cacheName);
        cacheInvalidationService.invalidateCacheByCacheName(cacheName);
        return "Success";
    }

    @RequestMapping(value = "/invalidateCache/{cacheName}/{cacheKey}", method = RequestMethod.GET)
    @ResponseBody
    public String invalidateCacheByCacheNameAndKey(@PathVariable String cacheName, @PathVariable String cacheKey) {
        LOG.info("Invalidating cache with cacheName:" + cacheName + " and cacheKey:" + cacheKey);
        cacheInvalidationService.invalidateCacheByCacheNameAndKey(cacheName, cacheKey);
        return "Success";
    }
}
