package com.first.oops_encapsulation;

public class EncapsulationExampleBankAccount {

	
	    private String accountNumber;  
	    private double balance; 
	    private String ifscCode;

	    public EncapsulationExampleBankAccount(String accountNumber) {
	        this.accountNumber = accountNumber;
	        this.balance = 0.0; 
	        ifscCode = null;
	    }

	    
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited: " + amount);
	        } else {
	            System.out.println("Deposit amount must be positive.");
	        }
	    }

	   
	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrew: " + amount);
	        } else {
	            System.out.println("Invalid withdrawal amount.");
	        }
	    }

	   
	    public double getBalance() {
	        return balance;
	    }

	    
	    public String getAccountNumber() {
	        return accountNumber;
	    }
	}
 

