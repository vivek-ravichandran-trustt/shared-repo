package com.example.ReportingService.service;


import com.example.ReportingService.DTO.CreditCardDTO;
import com.example.ReportingService.DTO.CreditCardResponse;
import com.example.ReportingService.models.CreditCard;
import com.example.ReportingService.repository.CreditCardRepository;

import java.util.List;

public interface CreditCardService {

    CreditCardDTO createCreditCard(CreditCardDTO creditCardDTO);

    CreditCardResponse getAllCustomers(int pageNo, int pageSize);
    CreditCardDTO getCustomerByID(int id);
    CreditCardDTO updateCustomer(CreditCardDTO creditCardDTO,int id);
    void deleteCustomer(int id);
}
