package com.antscode.kafkaproducer.controller;

import com.antscode.kafkaproducer.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageProducerController {

    private final KafkaProducer kafkaProducer;

    @GetMapping
    @RequestMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return  ResponseEntity.ok().body("Message sent successfully");
    }
}
