package com.steph.cleanarch.external.application.port.out.messaging;

/**
 * This is the interface class of the message producer functionality. Please implement this if
 * you want to use specific framework to be applied as a message broker.
 */
public interface MessagePublisherGateway {

    /**
     * Publish the message without any additional callback or functionality. Use this method if
     * you want to simply send the message.
     *
     * @param cmd the request data.
     * @param <T> the type of {@link MessagePublisherCmd#getCorrelationMetadata()}
     * @return {@link MessagePublisherDto}
     */
    <T> MessagePublisherDto<T> publish(MessagePublisherCmd<T> cmd);
}
