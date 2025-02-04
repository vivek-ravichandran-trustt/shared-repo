package com.example.ReportingService.service;

import com.example.ReportingService.DTO.CreditCardDTO;
import com.example.ReportingService.DTO.CreditCardResponse;
import com.example.ReportingService.exceptions.CustomerNotFoundException;
import com.example.ReportingService.models.CreditCard;
import com.example.ReportingService.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardImplementation implements CreditCardService {
    private CreditCardRepository creditcardRepository;
    @Autowired
    public CreditCardImplementation(CreditCardRepository creditcardRepository) {
        this.creditcardRepository = creditcardRepository;
    }
    @Override
    public CreditCardDTO createCreditCard(CreditCardDTO creditCardDTO) {
        //ipo dto la irnthu entity mathi repo la save panrom
        CreditCard creditcard= new CreditCard();
        creditcard.setCustomerName(creditCardDTO.getCustomerName());
        creditcard.setApplicationStatus(creditCardDTO.getApplicationStatus());
        creditcard.setAgentCode(creditCardDTO.getAgentCode());
        creditcard.setCompanyCode(creditCardDTO.getCompanyCode());
        //saves in repo
        CreditCard newCreditCard = creditcardRepository.save(creditcard);

        //entity vanthu changes back to dto and sends response
        CreditCardDTO creditResponse = new CreditCardDTO();
        creditResponse.setLeadReferenceNo(newCreditCard.getLeadReferenceNo());
        creditResponse.setCustomerName(newCreditCard.getCustomerName());
        creditResponse.setApplicationStatus(newCreditCard.getApplicationStatus());
        creditResponse.setAgentCode(newCreditCard.getAgentCode());
        creditResponse.setCompanyCode(newCreditCard.getCompanyCode());

        return creditResponse;
    }
    @Override
    public CreditCardResponse getAllCustomers(int pageNo, int pageSize){
        Pageable pageable=PageRequest.of(pageNo,pageSize);
        //exception check panrathuku
        //CreditCard creditCard3= creditcardRepository.findById(333333).orElseThrow(()->new CustomerNotFoundException("Customer was not found by id"))
        Page<CreditCard> creditcardPage=creditcardRepository.findAll(pageable);
        List<CreditCard> listOfCustomer=creditcardPage.getContent();
        //for loop no for each no
        //map return new list (benefit one)
        List<CreditCardDTO> content=listOfCustomer.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        CreditCardResponse creditCardResponse= new CreditCardResponse();
        creditCardResponse.setContent(content);
        creditCardResponse.setPageNo(creditcardPage.getNumber());
        creditCardResponse.setPageSize(creditcardPage.getSize());
        creditCardResponse.setTotalElements(creditcardPage.getTotalElements());
        creditCardResponse.setTotalPages(creditcardPage.getTotalPages());
        creditCardResponse.setLast(creditcardPage.isLast());
        return creditCardResponse;

    }

    @Override
    public CreditCardDTO getCustomerByID(int id) {
        //long and customer not found exception is in public()
        CreditCard creditCard = creditcardRepository.findById((long) id).orElseThrow(() -> new CustomerNotFoundException("Customer was not found by id"));
        return  mapToDto(creditCard);
    }

    @Override
    public CreditCardDTO updateCustomer(CreditCardDTO creditCardDTO, int id) {
        CreditCard creditCard = creditcardRepository.findById((long) id).orElseThrow(() -> new CustomerNotFoundException("Customer was not found by id"));
        creditCard.setCustomerName(creditCardDTO.getCustomerName());
        creditCard.setApplicationStatus(creditCardDTO.getApplicationStatus());
        creditCard.setAgentCode(creditCardDTO.getAgentCode());
        creditCard.setCompanyCode(creditCardDTO.getCompanyCode());
        CreditCard updateCustomer= creditcardRepository.save(creditCard);
        return mapToDto(updateCustomer);

    }

    @Override
    public void deleteCustomer(int id) {
        CreditCard creditCard= creditcardRepository.findById((long) id).orElseThrow(() -> new CustomerNotFoundException("Customer cant be deleted cause customer not found by id"));
        creditcardRepository.delete(creditCard);
    }

    private CreditCardDTO mapToDto(CreditCard creditCard){
        CreditCardDTO creditCardDTO= new CreditCardDTO();
        creditCardDTO.setLeadReferenceNo(creditCard.getLeadReferenceNo());
        creditCardDTO.setCustomerName(creditCard.getCustomerName());
        creditCardDTO.setApplicationStatus(creditCard.getApplicationStatus());
        creditCardDTO.setAgentCode(creditCard.getAgentCode());
        creditCardDTO.setCompanyCode(creditCard.getCompanyCode());
        return creditCardDTO;
    }
    private CreditCard mapToEntity(CreditCardDTO creditCardDTO){
        CreditCard creditCard= new CreditCard();
        creditCard.setLeadReferenceNo((creditCardDTO.getLeadReferenceNo()));
        creditCard.setCustomerName(creditCardDTO.getCustomerName());
        creditCard.setApplicationStatus(creditCardDTO.getApplicationStatus());
        creditCard.setAgentCode(creditCardDTO.getAgentCode());
        creditCard.setCompanyCode(creditCardDTO.getCompanyCode());
        return creditCard;
    }

}
//Service converts DTO to Entity → Saves Entity using Repository.
//Saved Entity is converted back to DTO → Returned as the response.
//this is called mapping
