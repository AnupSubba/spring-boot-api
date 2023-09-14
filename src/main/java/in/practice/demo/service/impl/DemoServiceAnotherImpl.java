package in.practice.demo.service.impl;

import in.practice.demo.service.DemoService;
import org.springframework.stereotype.Service;

public class DemoServiceAnotherImpl implements DemoService {

    @Override
    public String hello() {
        return "I am from DemoServiceAnotherImpl";
    }
}
