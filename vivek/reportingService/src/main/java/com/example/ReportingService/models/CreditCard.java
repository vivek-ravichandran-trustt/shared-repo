package com.example.ReportingService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.UUID)
    private int leadReferenceNo;
    private String customerName;
    private String applicationStatus;
    private int agentCode;
    private int companyCode;

    public CreditCard(int leadReferenceNo, String customerName, String applicationStatus, int agentCode, int companyCode) {
        this.leadReferenceNo = leadReferenceNo;
        this.customerName = customerName;
        this.applicationStatus = applicationStatus;
        this.agentCode = agentCode;
        this.companyCode = companyCode;
    }

    public CreditCard() {
    }

    public int getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(int leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public int getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(int agentCode) {
        this.agentCode = agentCode;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "leadReferenceNo=" + leadReferenceNo +
                ", customerName='" + customerName + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                ", agentCode=" + agentCode +
                ", companyCode=" + companyCode +
                '}';
    }
}
