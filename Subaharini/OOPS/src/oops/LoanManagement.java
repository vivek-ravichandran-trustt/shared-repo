package oops;
import java.util.Scanner;

//Interface is used here which allows different classes to implement the same method with their own implementations

interface LoanOperations {
    void applyForLoan();
    void calculateInterest();
    void approveLoan();
}

//Abstraction is used in loan class which provides a common base different types of loans..
//it has shared properties which is reused by subclasses..

abstract class Loan implements LoanOperations {
   //encapsulation is used here to make this private which cannot be accessed outside the loan class..
   //This makes the internal hidings like other classes home and car loan classes doesnt know about workings of Loan class..
	private double amount;
    private double interest;
    private double newInterest;

    public Loan(double amount, double interest) {
        this.amount = amount;
        this.interest = interest;
    }
    
    //provides public methods to access and modify to the private fields..
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void setNewInterest(double newInterest) {
        this.newInterest = newInterest;
    }

    public double getNewInterest() {
        return newInterest;
    }

    public void applyForLoan() {
        System.out.println("Loan amount applied is: " + amount);
    }

    //here the compile time polymorphism is used where the calculateInterest contains different parameters... 
    public void calculateInterest() {
        System.out.println("Interest for loan is: " + (amount * interest));
    }

    public void calculateInterest(double newInterest) {
        System.out.println("Interest for loan with new rate is: " + (amount * newInterest));
    }

    //abstract method which will be implemented by any subclass of loan class which has its own implementations..
    public abstract void approveLoan();
}

//HomeLoan and CarLoan classes uses inheritance for code reusability.. 
class HomeLoan extends Loan {
    public static final double maxHomeLoan=20000;
    HomeLoan(double amount, double interest) {
        super(amount, interest);
    }

    //method overriding is used here as run time polymorphism
    //both home loan and car loan has specific implementation method and based on the class the method gets overridden..
    public void approveLoan() {
        if (getAmount() > maxHomeLoan) {
            System.out.println("Home Loan not approved");
        } else {
            System.out.println("Home Loan approved");
        }
    }
}

class CarLoan extends Loan {
    public static final double maxCarLoan=30000;
    CarLoan(double amount, double interest) {
        super(amount, interest);
    }

    public void approveLoan() {
        if (getAmount() > maxCarLoan) {
            System.out.println("Car Loan not approved");
        } else {
            System.out.println("Car Loan approved");
        }
    }
}

public class LoanManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the amount and interest rate for Home Loan:");
        double homeLoanAmount = sc.nextDouble();
        double homeLoanInterest = sc.nextDouble();
        sc.nextLine();  
        Loan homeLoan = new HomeLoan(homeLoanAmount, homeLoanInterest);
        homeLoan.applyForLoan();
        homeLoan.calculateInterest();
        System.out.println("Do you need to update interest for Home Loan (Y or N):");
        String updateInterest = sc.nextLine();
        if (updateInterest.equalsIgnoreCase("Y")) {
            System.out.println("Enter new interest rate for Home Loan:");
            double newInterest = sc.nextDouble();
            sc.nextLine();  
            homeLoan.calculateInterest(newInterest);
        }
        homeLoan.approveLoan();
        System.out.println();
        System.out.println("Enter the amount and interest rate for Car Loan:");
        double carLoanAmount = sc.nextDouble();
        double carLoanInterest = sc.nextDouble();
        sc.nextLine(); 
        Loan carLoan = new CarLoan(carLoanAmount, carLoanInterest);
        carLoan.applyForLoan();
        carLoan.calculateInterest();

        System.out.println("Do you need to update interest for Car Loan (Y or N):");
        updateInterest = sc.nextLine();
        if (updateInterest.equalsIgnoreCase("Y")) {
            System.out.println("Enter new interest rate for Car Loan:");
            double newInterest = sc.nextDouble();
            carLoan.calculateInterest(newInterest);
        }
        carLoan.approveLoan();
        sc.close();
    }
}
