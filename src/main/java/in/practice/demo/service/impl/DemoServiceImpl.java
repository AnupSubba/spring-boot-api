package in.practice.demo.service.impl;

import in.practice.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String hello() {
        return "Hello";
    }
}
