package com.steph.cleanarch.movie.application.port.out.messaging;

public interface PlayedMovieMessagingGateway {
    void sendMessage(PlayedMovieMessage message);
}
