package in.practice.demo.api;

import in.practice.demo.config.InjectionHelper;
import in.practice.demo.config.PerformanceTimer;
import in.practice.demo.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:7171")
@RequestMapping("/api")
@RestController
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        final PerformanceTimer p = new PerformanceTimer("API Calling...");
        final DemoService demoService = InjectionHelper.getBean("demoServiceImpl");
        final String hello = demoService.hello();
        p.display();
        return ResponseEntity.ok(hello);
    }
}
