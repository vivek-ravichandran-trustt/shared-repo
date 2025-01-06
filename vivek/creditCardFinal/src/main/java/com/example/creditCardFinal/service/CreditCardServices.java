package com.example.creditCardFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.creditCardFinal.DTO.CreditCardReportDTO;
import com.example.creditCardFinal.entity.CreditCardReport;
import com.example.creditCardFinal.repository.CreditCardRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreditCardServices {

    @Autowired
    private CreditCardRepository repository;

    public double commissionRate(String agentCode) {
        long sales = repository.countByAgentCode(agentCode);
        if (sales >= 20) {
            return sales * 0.15 * 1000;
        } else if (sales >= 10) {
            return sales * 0.05 * 1000;
        }
        return 0.0;
    }

    public List<CreditCardReport> getAllReports() {

        return repository.findAll();
    }

    public Optional<CreditCardReport> getReportById(Integer id) {

        return repository.findById(id);
    }

    public CreditCardReport saveReport(CreditCardReport report) {

        return repository.save(report);
    }

    public void deleteReport(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Report with ID " + id + " does not exist.");
        }
    }

    public void updateCardStatus(int leadRefNo, String newStatus) {
        CreditCardReport report = repository.findById(leadRefNo).orElseThrow(() -> new IllegalArgumentException("Report not found"));
        report.setApplicationStatus(newStatus);
        report.setStatusUpdateDate(LocalDate.now());
        repository.save(report);
    }

    public List<Object[]> getTotalLeadsProcessedByAgent() {

        return repository.findTotalLeadsProcessedByAgent();
    }

    public List<Object[]> getLeadsWithSpecificCardStatuses() {

        return repository.findLeadsWithSpecificCardStatuses();
    }

    public List<Object[]> getAgentActivityCounts() {

        return repository.findAgentActivityCounts();
    }

    public List<Object[]> getLeadsBySource() {

        return repository.findLeadsBySource();
    }
    public List<CreditCardReportDTO> getAllReportsPaged(int page, int size, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        List<CreditCardReport> reports = repository.findAll(pageRequest).getContent();
        return reports.stream()
                .map(report -> new CreditCardReportDTO(
                        report.getLeadRefNo(), report.getCustomer(), report.getApplicationStatus(),
                        report.getAgentCode(), report.getCompanyCode(), report.getStatusUpdateDate(),
                        report.getLeadSource(), report.getActivityType()))
                .collect(Collectors.toList());
    }
}
