package com.steph.cleanarch.external.application.port.out.messaging;

import lombok.Value;

@Value(staticConstructor = "valueOf")
public class MessagePublisherDto<T> {

    /**
     * This field is to add additional information about the message we will be sent. Please be
     * aware that this object won't be sent to message broker, instead just to be a metadata about
     * the message to be sent.
     */
    T correlationMetadata;
}
