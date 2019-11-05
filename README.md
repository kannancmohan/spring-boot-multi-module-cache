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

#Cache adapter setting
set property "cache.adapter" to either "redis" or "simple"  
If "redis" is used ,make sure redis is installed 

#installing and running redis in mac
brew install redis
installation location: /usr/local/Cellar/redis/
conf file location:/usr/local/etc/redis.conf
start redis: brew services start redis
stop redis: brew services stop redis
default redis port:6379
for monitor redis activities: redis-cli monitor
