package com.steph.cleanarch.movie.adapter.out.persistence.entity;

import com.steph.cleanarch.movie.domain.Cast;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CastEntity {

    private String personId;

    private String movieId;

    private String character;

    public Cast toDomain() {
        return new Cast(personId, movieId, character);
    }

    public static CastEntity valueOf(Cast cast) {
        return new CastEntity(
            cast.personId(),
            cast.movieId(),
            cast.character()
        );
    }
}
