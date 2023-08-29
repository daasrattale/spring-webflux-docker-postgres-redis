package io.daasrattale.cloudnativepoc.config;

import io.daasrattale.cloudnativepoc.movie.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class RedisConfig {
    @Bean
    public ReactiveRedisTemplate<String, Movie> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Movie> serializer = new Jackson2JsonRedisSerializer<>(Movie.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Movie> builder =
                RedisSerializationContext.newSerializationContext(new Jackson2JsonRedisSerializer<>(String.class));
        RedisSerializationContext<String, Movie> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
