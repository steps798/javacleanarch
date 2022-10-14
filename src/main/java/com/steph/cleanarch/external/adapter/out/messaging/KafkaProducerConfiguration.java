package com.steph.cleanarch.external.adapter.out.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Bean
    public Map<String, Object> setupConfig() {
        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
//        configProps.put(ProducerConfig.ACKS_CONFIG, properties.getAck());
//        configProps.put(ProducerConfig.CLIENT_ID_CONFIG, properties.getClientId());
        return configProps;
    }
}
