package reportingService.creditCard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
public class CreditCardReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leadRefNo; // Unique identifier for each report (Primary Key)

    private String customer; // Customer's name or identification
    private String applicationStatus; // Status of the application (Pending, Activated, etc.)
    private String agentCode; // Code representing the agent handling the application
    private String companyCode; // Code for the company associated with the agent

    @Column(name = "status_update_date")
    private LocalDate statusUpdateDate; // Date when the status was last updated

    private String leadSource; // Source of the lead (e.g., online, referral, etc.)

    private String activityType; // Activity type for the report (e.g., Sell, Repair, Replace)

    public CreditCardReport(int leadRefNo, String customer, String applicationStatus, String agentCode, String companyCode,
                            LocalDate statusUpdateDate, String leadSource, String activityType) {
        this.leadRefNo = leadRefNo;
        this.customer = customer;
        this.applicationStatus = applicationStatus;
        this.agentCode = agentCode;
        this.companyCode = companyCode;
        this.statusUpdateDate = statusUpdateDate;
        this.leadSource = leadSource;
        this.activityType = activityType;
    }

    public CreditCardReport() {

    }

    public int getLeadRefNo() {
        return leadRefNo;
    }

    public void setLeadRefNo(int leadRefNo) {
        this.leadRefNo = leadRefNo;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public LocalDate getStatusUpdateDate() {
        return statusUpdateDate;
    }

    public void setStatusUpdateDate(LocalDate statusUpdateDate) {
        this.statusUpdateDate = statusUpdateDate;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Override
    public String toString() {
        return "CreditCardReport{" +
                "leadRefNo=" + leadRefNo +
                ", customer='" + customer + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                ", agentCode='" + agentCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", statusUpdateDate=" + statusUpdateDate +
                ", leadSource='" + leadSource + '\'' +
                ", activityType='" + activityType + '\'' +
                '}';
    }
}
