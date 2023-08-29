package io.daasrattale.cloudnativepoc.movie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public record MovieController(MovieService service) {

    @GetMapping
    public Flux<Movie> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Movie> save(@RequestBody Movie movie) {
        return service.save(movie);
    }

}
