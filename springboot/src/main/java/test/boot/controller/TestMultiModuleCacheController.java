package test.boot.controller;

import kcm.test.search.service.core.model.Product;
import kcm.test.search.service.core.service.ProductSearchService;
import kcm.test.some.service.SomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestMultiModuleCacheController {

    private static final Logger LOG = LoggerFactory.getLogger(TestMultiModuleCacheController.class);

    @Autowired
    private SomeService someService;

    @Autowired
    private ProductSearchService productSearchService;

    @RequestMapping(value = "/product/{id}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable String id) {
        Product product = productSearchService.getProduct(id);
        LOG.info("ProductSearchService::getProduct Value:" + product);
        return product;
    }

    @RequestMapping(value = "/someService/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getSomeService(@PathVariable String id) {
        String someValue = someService.getTest(id);
        LOG.info("SomeService::getTest Value:" + someValue);
        return "Success";
    }

}
