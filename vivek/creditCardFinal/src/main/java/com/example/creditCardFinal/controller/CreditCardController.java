package com.example.creditCardFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.creditCardFinal.DTO.CreditCardReportDTO;
import com.example.creditCardFinal.entity.CreditCardReport;
import com.example.creditCardFinal.service.CreditCardServices;
import com.example.creditCardFinal.service.KafkaProducerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reports")
public class CreditCardController {

    @Autowired
    private CreditCardServices service;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping
    public List<CreditCardReportDTO> getAllReports() {
        List<CreditCardReport> reports = service.getAllReports();
        return reports.stream()
                .map(report -> new CreditCardReportDTO(
                        report.getLeadRefNo(), report.getCustomer(), report.getApplicationStatus(),
                        report.getAgentCode(), report.getCompanyCode(), report.getStatusUpdateDate(),
                        report.getLeadSource(), report.getActivityType()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public CreditCardReportDTO createReport(@RequestBody CreditCardReport report) {
        CreditCardReport savedReport = service.saveReport(report);

        // Send the saved report to Kafka
        kafkaProducerService.sendMessage(savedReport.toString());

        return new CreditCardReportDTO(
                savedReport.getLeadRefNo(), savedReport.getCustomer(), savedReport.getApplicationStatus(),
                savedReport.getAgentCode(), savedReport.getCompanyCode(), savedReport.getStatusUpdateDate(),
                savedReport.getLeadSource(), savedReport.getActivityType());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable int id) {
        service.deleteReport(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{leadRefNo}/updateStatus")
    public ResponseEntity<Void> updateCardStatus(@PathVariable int leadRefNo, @RequestBody String newStatus) {
        service.updateCardStatus(leadRefNo, newStatus);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/commission/{agentCode}")
    public ResponseEntity<Double> getCommission(@PathVariable String agentCode) {
        double commission = service.commissionRate(agentCode);
        return ResponseEntity.ok(commission);
    }

    // Pagination and Sorting
    @GetMapping("/all")
    public List<CreditCardReportDTO> getAllReportsPaged(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size,
                                                        @RequestParam(defaultValue = "leadRefNo") String sortBy) {
        return service.getAllReportsPaged(page, size, sortBy);
    }
}
