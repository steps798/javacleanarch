package com.steph.cleanarch.external.application.port.out.messaging;

/**
 * Exception dedicated to be thrown from {@link MessagePublisherGateway}
 */
public class MessagePublisherException extends RuntimeException {

    private static final long serialVersionUID = 70389744043673725L;

    public MessagePublisherException(String message, Throwable t) {
        super(message, t);
    }
}
