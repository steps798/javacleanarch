package com.steph.cleanarch.movie.domain;

import java.time.Instant;

public record Review(
    String id,
    String userId,
    Double rate,
    Instant watchedDate,
    String review
) {

}
