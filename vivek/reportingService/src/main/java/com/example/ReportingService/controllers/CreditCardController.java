package com.example.ReportingService.controllers;

import com.example.ReportingService.DTO.CreditCardDTO;
import com.example.ReportingService.DTO.CreditCardResponse;
import com.example.ReportingService.models.CreditCard;
import com.example.ReportingService.service.CreditCardService;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CreditCardController {

    private CreditCardService creditcardService;
    @Autowired
    public CreditCardController(CreditCardService creditcardService) {
        this.creditcardService = creditcardService;
    }

    @GetMapping("customers")
    public ResponseEntity<CreditCardResponse> getCustomers(
            //pagination concept a padikanum
        @RequestParam(value = "pageNo",defaultValue = "0",required = false)int pageNo,
        @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize
    ){
        return new ResponseEntity<>(creditcardService.getAllCustomers(pageNo,pageSize),HttpStatus.OK);
    }
    @GetMapping("customers/{id}")
    public ResponseEntity<CreditCardDTO> getCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(creditcardService.getCustomerByID(id));
    }

    @PostMapping("creditcard/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreditCardDTO> createCustomer(@RequestBody CreditCardDTO creditcardDTO){
        return new ResponseEntity<>(creditcardService.createCreditCard(creditcardDTO),HttpStatus.CREATED);
    }
    @PutMapping("creditcard/{id}/update")
    public ResponseEntity<CreditCardDTO> updateCustomer(@RequestBody CreditCardDTO creditcardDTO,@PathVariable("id") int leadReferenceNo){
        CreditCardDTO response = creditcardService.updateCustomer(creditcardDTO,leadReferenceNo);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("creditcard/{id}/delete")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int leadRefernceNo){
        creditcardService.deleteCustomer(leadRefernceNo);
        return new ResponseEntity<>("Customer deleted succesfully",HttpStatus.OK);
    }
}
