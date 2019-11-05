package kcm.test.some.service.impl;

import kcm.test.some.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {

    public String getTest(String str) {
        System.out.println("Invoked original SomeService::getTest method --> " + str);
        return str;
    }
}
