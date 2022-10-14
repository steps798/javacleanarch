package com.steph.cleanarch.movie.adapter.out.messaging;

import com.steph.cleanarch.external.application.port.out.messaging.MessagePublisherGateway;
import com.steph.cleanarch.movie.application.port.out.messaging.PlayedMovieMessage;
import com.steph.cleanarch.movie.application.port.out.messaging.PlayedMovieMessagingGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayedMovieKafkaProducerGateway implements PlayedMovieMessagingGateway {

    private final MessagePublisherGateway kafkaMessagePublisherGateway;

    private final PlayedMovieKafkaProducerProperties properties;

    @Override
    public void sendMessage(PlayedMovieMessage message) {
//        kafkaMessagePublisherGateway.publish(properties.getTopic(), message.key(), message.message());
    }
}
