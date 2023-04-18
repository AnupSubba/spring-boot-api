package in.practice.demo;

import in.practice.demo.entity.Tutorial;
import in.practice.demo.repository.TutorialRepository;
import in.practice.demo.service.TutorialEvent;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;


@EnableWebFlux
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TutorialRepository repository) {
		return args -> {
			repository.deleteAll()
				.subscribe(null, null, () -> {
					Stream.of(new Tutorial(1), new Tutorial(2), new Tutorial(3), new Tutorial(4), new Tutorial(5),
							new Tutorial(6), new Tutorial(7), new Tutorial(8), new Tutorial(9), new Tutorial(10))
						.forEach(tutorial -> {
							repository.save(tutorial)
							.subscribe(System.out::println);
					});
				}
			);
		};
	}

	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		return initializer;
	}
}
