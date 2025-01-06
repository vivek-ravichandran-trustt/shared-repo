package com.example.ReportingService.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    //serial version na enna nu therila but lets finish it
    private static final long serialVonUID=1;
    public CustomerNotFoundException(String message){
        super(message);
    }
}
