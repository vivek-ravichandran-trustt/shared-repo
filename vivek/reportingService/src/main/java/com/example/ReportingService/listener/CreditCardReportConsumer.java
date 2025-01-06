package com.example.ReportingService.listener;

import com.example.ReportingService.models.CreditCard;  // Import your model
import com.example.ReportingService.repository.CreditCardRepository;  // Import your repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class CreditCardReportConsumer {

    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardReportConsumer(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    // Kafka listener for the "creditCardReports" topic
    @KafkaListener(topics = "creditCardReports", groupId = "creditCardGroup")
    public void consume(CreditCard creditCard) {
        // Save the received credit card data to the database
        creditCardRepository.save(creditCard);
        System.out.println("Consumed credit card: " + creditCard);
    }
}