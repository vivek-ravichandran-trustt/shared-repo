package reportingService.creditCard.DTO;

import java.time.LocalDate;

public class CreditCardReportDTO {

    private int leadRefNo;
    private String customer;
    private String applicationStatus;
    private String agentCode;
    private String companyCode;
    private LocalDate statusUpdateDate; // New field for status update date
    private String leadSource; // New field for lead source
    private String activityType; // New field for activity type

    public CreditCardReportDTO(int leadRefNo, String customer, String applicationStatus, String agentCode,
                               String companyCode, LocalDate statusUpdateDate, String leadSource, String activityType) {
        this.leadRefNo = leadRefNo;
        this.customer = customer;
        this.applicationStatus = applicationStatus;
        this.agentCode = agentCode;
        this.companyCode = companyCode;
        this.statusUpdateDate = statusUpdateDate;
        this.leadSource = leadSource;
        this.activityType = activityType;
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
        return "CreditCardReportDTO{" +
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
