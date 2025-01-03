package com.example.cr_card_management.repository;

import com.example.cr_card_management.entity.CreditCardApplication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, Long> {
    Optional<CreditCardApplication> findByLeadReferenceNumber(String leadReferenceNumber);
}
