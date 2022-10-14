package com.steph.cleanarch.external.application.port.out.messaging;

/**
 * The interface of message broker properties to be used in business logic layer.
 */
public interface MessagePublisherProperties {

    /**
     * Topics holder of message to be sent. Some kind of specific queue for specific message type.
     */
    Topic getTopic();

    interface Topic {

        String getPlayedMovie();
    }
}
