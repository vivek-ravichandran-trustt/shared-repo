package reportingService.creditCard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reportingService.creditCard.model.CreditCardReport;
import reportingService.creditCard.repository.CreditCardRepository;

import java.util.List;
import java.util.Optional;

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

    public Optional<CreditCardReport> getReportById(int id) {
        return repository.findById(id);
    }

    public CreditCardReport saveReport(CreditCardReport report) {
        return repository.save(report);
    }

    public void deleteReport(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Report with ID " + id + " does not exist.");
        }
    }

//    public CreditCardReport saveReport(CreditCardReport report) {
//        CreditCardReport saved = repository.save(report);
//        // Add a log statement to debug
//        System.out.println("Saved Report: " + saved);
//        return saved;
//    }
}


