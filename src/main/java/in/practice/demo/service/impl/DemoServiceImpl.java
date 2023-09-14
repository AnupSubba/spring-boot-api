package in.practice.demo.service.impl;

import in.practice.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

public class DemoServiceImpl implements DemoService {

    @Override
    public String hello() {
        return "I am from DemoServiceImpl";
    }
}
