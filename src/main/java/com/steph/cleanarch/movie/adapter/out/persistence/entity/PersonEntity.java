package com.steph.cleanarch.movie.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String fullName;

    private Instant dob;

    private String bio;

    private String profileUrl;

}
