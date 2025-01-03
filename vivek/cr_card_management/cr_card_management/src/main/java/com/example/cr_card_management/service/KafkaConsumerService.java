package com.example.cr_card_management.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "credit-card-topic", groupId = "credit-card-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
