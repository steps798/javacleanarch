package com.steph.cleanarch.movie.application.port.out.gateway;

import com.steph.cleanarch.movie.domain.Movie;

import java.util.List;

public interface MovieQueryGateway {

    /**
     * Find list of movies by its title
     *
     * @param title - title of the movie
     * @return list of movies with a title contains {@code title}
     */
    List<Movie> findByTitle(String title);
}
