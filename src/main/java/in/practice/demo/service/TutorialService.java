package in.practice.demo.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import in.practice.demo.repository.TutorialRepository;
import in.practice.demo.entity.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public Flux<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }


    public Mono<Tutorial> findById(int id) {
        return tutorialRepository.findById(id);
    }

    public Flux<TutorialEvent> getEvents(int id) {
        return tutorialRepository.findById(id)
            .flatMapMany(tutorial -> {
                Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
                Flux<TutorialEvent> tutorialEventFlux =
                    Flux.fromStream(
                            Stream.generate(() -> new TutorialEvent(tutorial, new Date()))
                    );
                return Flux.zip(interval, tutorialEventFlux)
                    .map(Tuple2::getT2);
            });
    }
}
