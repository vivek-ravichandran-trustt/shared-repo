package com.example.cr_card_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cr_card_management.service.KafkaProducerService;

import java.util.Map;

@RestController
@RequestMapping("/api/credit-card")
public class CreditCardController {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public CreditCardController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/report")
    public ResponseEntity<String> sendCreditCardReport(@RequestBody CreditCardController report) {
        System.out.println("Received request to send credit card report");
        kafkaProducerService.sendReportToKafka(report);
        return ResponseEntity.ok("Report sent to Kafka");
    }

}
