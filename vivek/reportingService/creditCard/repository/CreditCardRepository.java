package reportingService.creditCard.repository;

import reportingService.creditCard.entity.CreditCardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardReport, Integer> {

    long countByAgentCode(String agentCode);

    @Query("SELECT c.agentCode, COUNT(c) FROM CreditCardReport c GROUP BY c.agentCode")
    List<Object[]> findTotalLeadsProcessedByAgent();

    @Query("SELECT c.applicationStatus, COUNT(c) FROM CreditCardReport c GROUP BY c.applicationStatus")
    List<Object[]> findLeadsWithSpecificCardStatuses();

    @Query("SELECT c.agentCode, SUM(CASE WHEN c.activityType = 'Sell' THEN 1 ELSE 0 END) AS sellCount, " +
            "SUM(CASE WHEN c.activityType = 'Repair' THEN 1 ELSE 0 END) AS repairCount, " +
            "SUM(CASE WHEN c.activityType = 'Replace' THEN 1 ELSE 0 END) AS replaceCount " +
            "FROM CreditCardReport c GROUP BY c.agentCode")
    List<Object[]> findAgentActivityCounts();

    @Query("SELECT c.leadSource, COUNT(c) FROM CreditCardReport c GROUP BY c.leadSource")
    List<Object[]> findLeadsBySource();
}
