package com.steph.cleanarch.movie.domain;

import java.time.Instant;

public record Person(
    String id,
    String fullName,
    Instant dob,
    String bio,
    String profileUrl
) {

}
