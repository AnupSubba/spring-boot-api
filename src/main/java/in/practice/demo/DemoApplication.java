package in.practice.demo;

import in.practice.demo.service.DemoService;
import in.practice.demo.service.impl.DemoServiceAnotherImpl;
import in.practice.demo.service.impl.DemoServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public DemoService demoServiceImpl() {
		return new DemoServiceImpl();
	}

	@Bean
	public DemoService demoServiceAnotherImpl() {
		return new DemoServiceAnotherImpl();
	}
}
