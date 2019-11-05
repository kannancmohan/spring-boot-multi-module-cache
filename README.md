# spring-boot-multi-module-cache

#Run maven
mvn clean install

#Run spring boot
run SpringBootApp from IDE

#Enable/Disable cache for some-service-moduel
some.service.module.cache.enabled=true

#Enable/Disable cache for search-service-moduel
search.service.module.cache.enabled=true

#cache invalidation endpoints
To invalidate cache by cache name and cache key :http://localhost:9090/invalidateCache/{cache-name}/{cache-key}
To Invalidate all cache http://localhost:9090/invalidateAllCache
