package com.steph.cleanarch.movie.application.port.in.updatecastcrew;

import java.util.List;

public record UpdateCastCrewCmd(
    String movieId,
    List<CastCmd> casts,
    List<CrewCmd> crews
) {

    public record CastCmd(
        String personId,
        String character
    ) {
    }

    public record CrewCmd(
        String personId,
        String role
    ) {
    }
}
