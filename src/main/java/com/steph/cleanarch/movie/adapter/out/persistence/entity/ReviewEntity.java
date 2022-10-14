package com.steph.cleanarch.movie.adapter.out.persistence.entity;

import com.steph.cleanarch.movie.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Double rate;

    @Column(nullable = false)
    private Instant watchedDate;

    @Column(length = 1000)
    private String review;

    public Review toDomain() {
        return new Review(
            id,
            userId,
            rate,
            watchedDate,
            review
        );
    }

    public static ReviewEntity valueOf(Review review) {
        return new ReviewEntity(
            review.id(),
            review.userId(),
            review.rate(),
            review.watchedDate(),
            review.review()
        );
    }
}
