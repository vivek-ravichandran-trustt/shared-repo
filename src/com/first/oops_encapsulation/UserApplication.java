package com.first.oops_encapsulation;

public class UserApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        
		        EncapsulationExampleBankAccount account = new EncapsulationExampleBankAccount("126789");

		        // Display account details
		        System.out.println("Account Number: " + account.getAccountNumber());
		        System.out.println("Initial Balance: " + account.getBalance());

		        // Deposit money
		        account.deposit(500.0);
		        System.out.println("Current Balance: " + account.getBalance());

		        // Withdraw money
		        account.withdraw(200.0);
		        System.out.println("Current Balance: " + account.getBalance());

		        // Attempt to withdraw more than the balance
		        account.withdraw(400.0);
		    }
		

	}

