package com.steph.cleanarch.movie.adapter.out.persistence;

import com.steph.cleanarch.movie.adapter.out.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<MovieEntity, String> {

    List<MovieEntity> findByTitle(String title);
}
