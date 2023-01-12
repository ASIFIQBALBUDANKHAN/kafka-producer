package com.antscode.kafkaproducer.service;

import com.antscode.kafkaproducer.constants.KafkaConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Sending message to Topic {}  with message {}", KafkaConstants.TOPIC_NAME, message);
        kafkaTemplate.send(KafkaConstants.TOPIC_NAME, message);
    }
}
