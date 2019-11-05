package test.boot;

import kcm.test.cache.invalidator.service.CacheInvalidationService;
import kcm.test.some.service.SomeService;
import kcm.test.search.service.core.model.Product;
import kcm.test.search.service.core.service.ProductSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/*@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAutoConfiguration*/
/*@SpringBootConfiguration
@EnableAutoConfiguration*/
@SpringBootApplication
public class SpringBootApp {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootApp.class);

    @Autowired
    ProductSearchService productSearchService;

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        //TODO move these test to proper Test classes
        ApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
        Environment environment = ctx.getBean(Environment.class);
        ProductSearchService productSearchService = ctx.getBean(ProductSearchService.class);


        Product test1 = productSearchService.getTest("1234");
        System.out.println("test1 " + test1);
        Product test2 = productSearchService.getTest("1234");
        System.out.println("test2 " + test2);
        SomeService someService = ctx.getBean(SomeService.class);
        System.out.println("test3 " + someService.getTest("hello"));
        System.out.println("test4 " + someService.getTest("hello"));
        CacheInvalidationService cacheInvalidationService = ctx.getBean(CacheInvalidationService.class);

        cacheInvalidationService.invalidateCacheByCacheName("some-cache");
        System.out.println("test5 " + someService.getTest("hello"));
        System.out.println("test6 " + someService.getTest("hello"));

    }
}
