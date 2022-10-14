package com.steph.cleanarch.external.adapter.out.messaging;

import com.steph.cleanarch.external.application.port.out.messaging.MessagePublisherProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties implements MessagePublisherProperties {

    private String bootstrapServers;

    private TopicProperties topic;

    private String ack;

    @Data
    static class TopicProperties implements Topic {

        private String playedMovie;
    }
}
