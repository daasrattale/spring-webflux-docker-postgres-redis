package io.daasrattale.cloudnativepoc.movie;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MovieRepository extends ReactiveCrudRepository<Movie, Long> {
}
