package reportingService.creditCard.repository;

import reportingService.creditCard.model.CreditCardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository <CreditCardReport, Integer>{
    long countByAgentCode(String agentCode);
}
