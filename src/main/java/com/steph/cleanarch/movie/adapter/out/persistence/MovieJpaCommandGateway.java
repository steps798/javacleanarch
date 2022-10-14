package com.steph.cleanarch.movie.adapter.out.persistence;

import com.steph.cleanarch.movie.adapter.out.persistence.entity.MovieEntity;
import com.steph.cleanarch.movie.application.port.out.gateway.MovieCommandGateway;
import com.steph.cleanarch.movie.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieJpaCommandGateway implements MovieCommandGateway {

    private final MovieRepository movieRepository;

    @Override
    public Optional<Movie> fetchById(String id) {
        return movieRepository.findById(id)
            .map(MovieEntity::toDomain);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(MovieEntity.valueOf(movie)).toDomain();
    }

}
