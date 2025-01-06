package com.example.creditCardFinal.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.creditCardFinal.entity.CreditCardReport;
import com.example.creditCardFinal.repository.CreditCardRepository;

@Service
public class KafkaConsumerService {

    private final CreditCardRepository repository;

    public KafkaConsumerService(CreditCardRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "credit_card_reports", groupId = "creditCardGroup")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);

        // Assuming the message is in JSON format (you might need to implement a proper parser)
        // Here you need a way to parse the message into the entity class `CreditCardReport`
        CreditCardReport report = new CreditCardReport();
        // Parse message and map to report entity (example)
        repository.save(report);
    }
}
