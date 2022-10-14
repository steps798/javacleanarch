package com.steph.cleanarch.external.adapter.out.messaging;

import com.steph.cleanarch.external.application.port.out.messaging.MessagePublisherCmd;
import com.steph.cleanarch.external.application.port.out.messaging.MessagePublisherDto;
import com.steph.cleanarch.external.application.port.out.messaging.MessagePublisherGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessagePublisherGateway implements MessagePublisherGateway {

    @Override
    public <T> MessagePublisherDto<T> publish(MessagePublisherCmd<T> cmd) {

//        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(
//            setupConfig(),
//            new StringSerializer(),
//            new StringSerializer()
//        );
//
//        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);
//        kafkaTemplate.send(cmd.getTopic(), cmd.getKey(), cmd.getMessage());
        return null;
    }
}
