package reportingService.creditCard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reportingService.creditCard.model.CreditCardReport;
import reportingService.creditCard.service.CreditCardServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reports")
public class CreditCardController {

    @Autowired
    private CreditCardServices service;

    // Get all reports
    @GetMapping
    public ResponseEntity<List<CreditCardReport>> getAllReports() {
        List<CreditCardReport> reports = service.getAllReports();
        if (reports.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    // Get report by ID
    @GetMapping("/{id}")
    public ResponseEntity<CreditCardReport> getReportById(@PathVariable int id) {
        Optional<CreditCardReport> report = service.getReportById(id);
        return report.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new report
    @PostMapping
    public ResponseEntity<CreditCardReport> createReport(@RequestBody CreditCardReport report) {
        if (report == null) {
            return ResponseEntity.badRequest().build(); // Handle invalid input
        }
        CreditCardReport savedReport = service.saveReport(report);
        return ResponseEntity.status(201).body(savedReport); // Returning a 201 status for created resource
    }

    // Delete report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable int id) {
        if (service.getReportById(id).isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if report not found
        }
        service.deleteReport(id);
        return ResponseEntity.noContent().build(); // 204 No Content for successful delete
    }

    // Get commission for an agent
    @GetMapping("/commission/{agentCode}")
    public ResponseEntity<Double> getCommission(@PathVariable String agentCode) {
        double commission = service.commissionRate(agentCode);
        if (commission > 0) {
            return ResponseEntity.ok(commission);
        } else {
            return ResponseEntity.status(404).body(0.0); // Return 404 if no commission is found
        }
    }
}
