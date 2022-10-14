package com.steph.cleanarch.movie.domain;

import java.time.Instant;
import java.util.List;

public record Movie(
    String id,
    String title,
    String synopsis,
    Instant releasedDate,
    String posterUrl,
    List<Cast> casts,
    List<Crew> crews,
    List<Review> reviews
) {

}
