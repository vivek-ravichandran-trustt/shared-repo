package com.example.cr_card_management.repository;

import com.example.cr_card_management.entity.CreditCardApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, Long> {
    Optional<CreditCardApplication> findByLeadReferenceNumber(String leadReferenceNumber);
    Page<CreditCardApplication> findAll(Pageable pageable);
}
