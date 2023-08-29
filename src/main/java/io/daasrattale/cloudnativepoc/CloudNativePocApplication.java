package io.daasrattale.cloudnativepoc;

import io.daasrattale.cloudnativepoc.movie.Movie;
import io.daasrattale.cloudnativepoc.movie.MovieRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
public class CloudNativePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativePocApplication.class, args);
	}


	@Bean
	public ApplicationRunner saveMovies(MovieRepository repository) {
		Flux<Movie> movies = Flux.just(
				new Movie(null, "Catch me if you can"),
				new Movie(null, "Interstellar"),
				new Movie(null, "Fight Club"),
				new Movie(null, "Creed"),
				new Movie(null, "The Godfather")
		);
		return args -> repository.deleteAll()
				.thenMany(repository.saveAll(movies))
				.subscribe(System.out::println);
	}

}
