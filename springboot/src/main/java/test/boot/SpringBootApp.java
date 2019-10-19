package test.boot;

import kcm.test.another.cache.service.AnotherService;
import kcm.test.search.service.core.model.Product;
import kcm.test.search.service.core.service.ProductSearchService;
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

    @Autowired
    ProductSearchService productSearchService;

    @Autowired
    private Environment env;

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
        Environment environment = ctx.getBean(Environment.class);
        ProductSearchService productSearchService = ctx.getBean(ProductSearchService.class);


        Product test1 = productSearchService.getTest();
        System.out.println("test1" + test1);
        Product test2 = productSearchService.getTest();
        System.out.println("test2" + test2);
        AnotherService anotherService = ctx.getBean(AnotherService.class);
        System.out.println("test3" + anotherService.getTest("hello"));
        System.out.println("test4" + anotherService.getTest("hello"));
    }
}
