package com.steph.cleanarch.movie.application.port.in.findbytitle;

import com.steph.cleanarch.movie.domain.Movie;

import java.time.Instant;

public record FindByTitleDto(
    String title,
    String synopsis,
    Instant releasedDate,
    String posterUrl
) {
    public static FindByTitleDto valueOf(Movie movie) {
        return new FindByTitleDto(
            movie.title(),
            movie.synopsis(),
            movie.releasedDate(),
            movie.posterUrl()
        );
    }
}
