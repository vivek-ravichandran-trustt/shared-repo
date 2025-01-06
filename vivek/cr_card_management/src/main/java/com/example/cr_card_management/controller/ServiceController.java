package com.example.cr_card_management.controller;

import com.example.cr_card_management.service.CreditCardApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private CreditCardApplicationService service;

    @PostMapping("/process")
    public ResponseEntity<String> processCreditCard(@RequestParam String leadReferenceNumber) {
        String result = service.processApplication(leadReferenceNumber);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/status/{leadReferenceNumber}")
    public ResponseEntity<String> getApplicationStatus(@PathVariable String leadReferenceNumber) {
        String status = service.getApplicationStatus(leadReferenceNumber);
        return new ResponseEntity<>("Application Status: " + status, HttpStatus.OK);
    }
}






