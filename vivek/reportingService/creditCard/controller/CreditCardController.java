package reportingService.creditCard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reportingService.creditCard.DTO.CreditCardReportDTO;
import reportingService.creditCard.entity.CreditCardReport;
import reportingService.creditCard.service.CreditCardServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reports")
public class CreditCardController {

    @Autowired
    private CreditCardServices service;

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

    @GetMapping("/{id}")
    public ResponseEntity<CreditCardReportDTO> getReportById(@PathVariable int id) {
        return service.getReportById(id)
                .map(report -> new CreditCardReportDTO(
                        report.getLeadRefNo(), report.getCustomer(), report.getApplicationStatus(),
                        report.getAgentCode(), report.getCompanyCode(), report.getStatusUpdateDate(),
                        report.getLeadSource(), report.getActivityType()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CreditCardReportDTO createReport(@RequestBody CreditCardReport report) {
        CreditCardReport savedReport = service.saveReport(report);
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

    @GetMapping("/totalLeadsByAgent")
    public List<Object[]> getTotalLeadsProcessedByAgent() {
        return service.getTotalLeadsProcessedByAgent();
    }

    @GetMapping("/leadsByStatus")
    public List<Object[]> getLeadsWithSpecificCardStatuses() {
        return service.getLeadsWithSpecificCardStatuses();
    }

    @GetMapping("/agentActivityCounts")
    public List<Object[]> getAgentActivityCounts() {
        return service.getAgentActivityCounts();
    }

    @GetMapping("/leadsBySource")
    public List<Object[]> getLeadsBySource() {
        return service.getLeadsBySource();
    }
}
