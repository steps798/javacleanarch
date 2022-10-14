package com.steph.cleanarch.movie.application.port.out.gateway;

import com.steph.cleanarch.movie.domain.Movie;

import java.util.Optional;

public interface MovieCommandGateway {

    /**
     * Fetch a movie by its id
     *
     * @param id - id of the movie
     * @return a movie with id matches {@code id}
     */
    Optional<Movie> fetchById(String id);

    Movie save(Movie movie);
}
