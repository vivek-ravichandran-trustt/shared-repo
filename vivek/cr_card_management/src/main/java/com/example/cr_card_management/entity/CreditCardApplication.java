package com.example.cr_card_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class CreditCardApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Lead Reference Number cannot be blank")
    @Column(unique = true, nullable = false)
    private String leadReferenceNumber;

    @NotBlank(message = "Customer Name cannot be blank")
    @Column(nullable = false)
    private String customerName;

    @NotBlank(message = "Agent Code cannot be blank")
    @Column(nullable = false)
    private String agentCode;

    @NotBlank(message = "Company Code cannot be blank")
    @Column(nullable = false)
    private String companyCode;

    private String applicationStatus = "Pending";

    @Min(value = 1, message = "Customer income cannot be empty")
    @Column(nullable = false)
    private double customerIncome;

    @Min(value = 1, message = "Credit score cannot be empty")
    @Column(nullable = false)
    private int creditScore;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeadReferenceNumber() {
        return leadReferenceNumber;
    }

    public void setLeadReferenceNumber(String leadReferenceNumber) {
        this.leadReferenceNumber = leadReferenceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public double getCustomerIncome() {
        return customerIncome;
    }

    public void setCustomerIncome(double customerIncome) {
        this.customerIncome = customerIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
