package com.steph.cleanarch.movie.adapter.in.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlayedMovieConsumer {

//    private final SaveMovieUseCase saveMovieUseCase;

    public void consumePlayedMovie(Object message) {
        log.info("consumePlayedMovie key: {}");

//        saveMovieUseCase.save(new Movie());
    }
}
