package com.steph.cleanarch.movie.application.port.in.updatecastcrew;

import com.steph.cleanarch.movie.application.port.out.gateway.MovieCommandGateway;
import com.steph.cleanarch.movie.domain.Cast;
import com.steph.cleanarch.movie.domain.Crew;
import com.steph.cleanarch.movie.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UpdateCastCrewService implements UpdateCastCrewUseCase {

    private final MovieCommandGateway movieCommandGateway;

    @Override
    public void updateCastCrew(UpdateCastCrewCmd cmd) {
        Movie movie = movieCommandGateway.fetchById(cmd.movieId())
            .orElseThrow(EntityNotFoundException::new);

        List<Cast> updatedCasts = cmd.casts()
            .stream()
            .map(updatedCast -> new Cast(updatedCast.personId(), movie.id(), updatedCast.character()))
            .collect(Collectors.toList());

        List<Crew> updatedCrews = cmd.crews()
            .stream()
            .map(updatedCrew -> new Crew(updatedCrew.personId(), movie.id(), updatedCrew.role()))
            .collect(Collectors.toList());

        Movie updatedMovie = new Movie(
            movie.id(),
            movie.title(),
            movie.synopsis(),
            movie.releasedDate(),
            movie.posterUrl(),
            updatedCasts,
            updatedCrews,
            movie.reviews()
        );

        movieCommandGateway.save(updatedMovie);
    }
}
