package com.steph.cleanarch.movie.domain;

public record Crew(
    String personId,
    String movieId,
    String role
) {

}
