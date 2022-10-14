package com.steph.cleanarch.movie.adapter.out.persistence.entity;

import com.steph.cleanarch.movie.domain.Crew;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CrewEntity {

    private String personId;

    private String movieId;

    private String role;

    public Crew toDomain() {
        return new Crew(personId, movieId, role);
    }

    public static CrewEntity valueOf(Crew crew) {
        return new CrewEntity(
            crew.personId(),
            crew.movieId(),
            crew.role()
        );
    }
}
