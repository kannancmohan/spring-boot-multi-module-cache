package kcm.test.another.cache.service.impl;

import kcm.test.another.cache.service.AnotherService;
import org.springframework.stereotype.Service;

@Service
public class AnotherServiceImpl implements AnotherService {

    public String getTest(String str) {
        System.out.println("INSIDE AnotherService:getTest");
        return str;
    }
}
