 package com.example.cr_card_management.service;

    import com.example.cr_card_management.entity.CreditCardApplication;
    import com.example.cr_card_management.repository.CreditCardApplicationRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.Optional;

    @Service
    public class CreditCardApplicationService {

        @Autowired
        private CreditCardApplicationRepository repository;

        public CreditCardApplication submitApplication(CreditCardApplication application) {
            return repository.save(application);
        }

        public CreditCardApplication getApplicationById(Long id) {
            Optional<CreditCardApplication> application = repository.findById(id);
            return application.orElse(null);
        }

        public CreditCardApplication updateApplication(Long id, CreditCardApplication updatedApplication) {
            if (repository.existsById(id)) {
                updatedApplication.setId(id);
                return repository.save(updatedApplication);
            }
            return null;
        }

        public boolean deleteApplication(Long id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            }
            return false;
        }

        public String processApplication(String leadReferenceNumber) {
            Optional<CreditCardApplication> optionalApplication = repository.findByLeadReferenceNumber(leadReferenceNumber);

            if (optionalApplication.isPresent()) {
                CreditCardApplication application = optionalApplication.get();

                if (application.getCustomerIncome() >= 70000 && application.getCreditScore() >= 700) {
                    application.setApplicationStatus("Approved");
                } else {
                    application.setApplicationStatus("Rejected");
                }

                repository.save(application);
                return application.getApplicationStatus();
            }

            return "Application not found";
        }

        public String getApplicationStatus1(String leadReferenceNumber) {
            Optional<CreditCardApplication> optionalApplication = repository.findByLeadReferenceNumber(leadReferenceNumber);

            if (optionalApplication.isPresent()) {
                return optionalApplication.get().getApplicationStatus();
            }

            return "Application not found";
        }
    

    public String getApplicationStatus(String leadReferenceNumber) {
        Optional<CreditCardApplication> optionalApplication = repository.findByLeadReferenceNumber(leadReferenceNumber);

        if (optionalApplication.isPresent()) {
            return optionalApplication.get().getApplicationStatus();
        }

        return "Application not found";
    }
}
