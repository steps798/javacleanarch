package com.steph.cleanarch.movie.adapter.out.persistence.entity;

import com.steph.cleanarch.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String synopsis;

    @Column(nullable = false)
    private Instant releasedDate;

    private String posterUrl;

    @OneToMany
    private List<CastEntity> casts;

    @OneToMany
    private List<CrewEntity> crews;

    @OneToMany
    private List<ReviewEntity> reviews;

    public static MovieEntity valueOf(Movie movie) {
        return new MovieEntity(
            movie.id(),
            movie.title(),
            movie.synopsis(),
            movie.releasedDate(),
            movie.posterUrl(),
            movie.casts()
                .stream()
                .map(CastEntity::valueOf)
                .collect(Collectors.toList()),
            movie.crews()
                .stream()
                .map(CrewEntity::valueOf)
                .collect(Collectors.toList()),
            movie.reviews()
                .stream()
                .map(ReviewEntity::valueOf)
                .collect(Collectors.toList())
        );
    }

    public Movie toDomain() {
        return new Movie(
            id,
            title,
            synopsis,
            releasedDate,
            posterUrl,
            casts.stream()
                .map(CastEntity::toDomain)
                .collect(Collectors.toList()),
            crews.stream()
                .map(CrewEntity::toDomain)
                .collect(Collectors.toList()),
            reviews.stream()
                .map(ReviewEntity::toDomain)
                .collect(Collectors.toList())
        );
    }
}
