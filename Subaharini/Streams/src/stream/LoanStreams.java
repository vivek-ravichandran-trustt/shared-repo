package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


abstract class Loan {
    private double amount;
    private double interest;

    public Loan(double amount, double interest) {
        this.amount = amount;
        this.interest = interest;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterest() {
        return interest;
    }
}

class HomeLoan extends Loan {
    HomeLoan(double amount, double interest) {
        super(amount, interest);
    }
}

class CarLoan extends Loan {
    CarLoan(double amount, double interest) {
        super(amount, interest);
    }
}

public class LoanStreams {
    public static void main(String[] args) {
        
        List<Loan> loans = new ArrayList<>();
        loans.add(new HomeLoan(15000, 0.05));
        loans.add(new HomeLoan(25000, 0.06));
        loans.add(new CarLoan(18000, 0.07));
        loans.add(new CarLoan(35000, 0.08));

        System.out.println("Approved Loans:");
        
        loans.stream()
        //filter is used instead of approveLoan() to check the condition  
        .filter(loan -> (loan instanceof HomeLoan && loan.getAmount() <= 20000)
                     || (loan instanceof CarLoan && loan.getAmount() <= 30000))
        .forEach(loan -> System.out.println("Approved Loan: Amount = " + loan.getAmount()));

        
        double totalInterest = loans.stream()
        	//converts loan objects to double values and calculate the total interest without function
            .mapToDouble(loan -> loan.getAmount() * loan.getInterest())
            .sum();
        System.out.println("Total interest for all loans: " + totalInterest);

       
        List<Loan> largeLoans = loans.stream()
            .filter(loan -> loan.getAmount() > 20000)
            .collect(Collectors.toList());

        System.out.println("Loans with amount greater than 20,000:");
        largeLoans.forEach(loan -> System.out.println("Loan amount: " + loan.getAmount()));
    }
}

