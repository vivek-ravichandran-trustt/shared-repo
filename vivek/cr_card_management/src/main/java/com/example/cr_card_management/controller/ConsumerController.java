package com.example.cr_card_management.controller;

import com.example.cr_card_management.entity.CreditCardApplication;
import com.example.cr_card_management.service.CreditCardApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    private final CreditCardApplicationService service;

    @Autowired
    public ConsumerController(CreditCardApplicationService service) {
        this.service = service;
    }

    @PostMapping("/apply")
    public ResponseEntity<CreditCardApplication> applyForCreditCard(
            @Validated @RequestBody CreditCardApplication request) {
        CreditCardApplication savedApplication = service.submitApplication(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<CreditCardApplication> getApplicationById(@PathVariable Long id) {
        CreditCardApplication application = service.getApplicationById(id);
        return application != null
                ? ResponseEntity.ok(application)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/application/{id}")
    public ResponseEntity<CreditCardApplication> updateApplication(
            @PathVariable Long id, 
            @RequestBody CreditCardApplication updatedApplication) {
        CreditCardApplication application = service.updateApplication(id, updatedApplication);
        return application != null
                ? ResponseEntity.ok(application)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        return service.deleteApplication(id)
                ? ResponseEntity.ok("Application deleted successfully")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Application not found");
    }

    @GetMapping("/applications")
    public ResponseEntity<Page<CreditCardApplication>> getAllApplications(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "applicationStatus") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("asc") 
                    ? Sort.by(sortBy).ascending() 
                    : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<CreditCardApplication> applications = service.getAllApplications(pageable);
        return ResponseEntity.ok(applications);
    }
}














//package com.example.cr_card_management.controller;
//
//import com.example.cr_card_management.entity.CreditCardApplication;
//import com.example.cr_card_management.service.CreditCardApplicationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/consumer")
//public class ConsumerController {
//
//    @Autowired
//    private CreditCardApplicationService service;
//
//    @PostMapping("/apply")
//    public ResponseEntity<CreditCardApplication> applyForCreditCard(@Validated @RequestBody CreditCardApplication request) {
//        CreditCardApplication savedApplication = service.submitApplication(request);
//        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/application/{id}")
//    public ResponseEntity<CreditCardApplication> getApplicationById(@PathVariable Long id) {
//        CreditCardApplication application = service.getApplicationById(id);
//        if (application != null) {
//            return new ResponseEntity<>(application, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("/application/{id}")
//    public ResponseEntity<CreditCardApplication> updateApplication(@PathVariable Long id, @RequestBody CreditCardApplication updatedApplication) {
//        CreditCardApplication application = service.updateApplication(id, updatedApplication);
//        if (application != null) {
//            return new ResponseEntity<>(application, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/application/{id}")
//    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
//        if (service.deleteApplication(id)) {
//            return new ResponseEntity<>("Application deleted successfully", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Application not found", HttpStatus.NOT_FOUND);
//    }
//    
//    
//}
//
//
//
