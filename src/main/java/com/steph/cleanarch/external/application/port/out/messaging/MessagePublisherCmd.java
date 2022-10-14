package com.steph.cleanarch.external.application.port.out.messaging;

import lombok.Value;

@Value(staticConstructor = "valueOf")
public class MessagePublisherCmd<T> {

    /**
     * Topic of message to be sent. Some kind of specific queue for specific message type.
     */
    String topic;

    /**
     * The JSON formatted String as a message to be sent to message broker.
     */
    String message;

    String key;

    /**
     * This field is to add additional information about the message we will be sent. Please be
     * aware that this object won't be sent to message broker, instead just to be a metadata about
     * the message to be sent.
     */
    T correlationMetadata;
}
