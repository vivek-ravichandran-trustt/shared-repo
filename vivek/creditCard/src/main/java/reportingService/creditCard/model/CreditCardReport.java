package reportingService.creditCard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardReport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadRefNo;

    private String customer;

    private String applicationStatus;

    private String agentCode;

    private String companyCode;

    @Override
    public String toString() {
        return "CreditCardReport{" +
                "leadRefNo=" + leadRefNo +
                ", customer='" + customer + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                ", agentCode='" + agentCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                '}';
    }
}
