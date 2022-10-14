package com.steph.cleanarch.movie.adapter.out.persistence;

import com.steph.cleanarch.movie.adapter.out.persistence.entity.MovieEntity;
import com.steph.cleanarch.movie.application.port.out.gateway.MovieQueryGateway;
import com.steph.cleanarch.movie.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieJpaQueryGateway implements MovieQueryGateway {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title)
            .stream()
            .map(MovieEntity::toDomain)
            .collect(Collectors.toList());
    }
}
