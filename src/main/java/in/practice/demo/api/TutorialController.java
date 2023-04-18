package in.practice.demo.api;

import in.practice.demo.entity.Tutorial;
import in.practice.demo.service.TutorialEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import in.practice.demo.service.TutorialService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:7171")
@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @GetMapping("/tutorials/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Tutorial> getAllTutorials() {
        return tutorialService.findAll();
    }

    @GetMapping("/tutorials/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Tutorial> getTutorialById(@PathVariable("id") int id) {
        return tutorialService.findById(id);
    }

    @GetMapping(value = "/tutorials/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<TutorialEvent> getEvents(@PathVariable("id") int id) {
        return tutorialService.getEvents(id);
    }
}
