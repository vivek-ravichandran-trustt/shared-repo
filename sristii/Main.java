import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//oops overview
//abstraction(hiding the actual implementation details and exposing onlu functionality)
abstract class AccountOperations {
    abstract void accountSummary();//abstract method

    public void greeting() {
        //concrete method
        System.out.println("Welcome to banking System");
    }
}

//idea of interface
//interface used to achieve abstraction,multiple inheritance
//multiple inheritance not supported in java so
//can be acheived from interface
interface AccountManagement {
    void changeId(int newId);

    void changeName(String newname);

    void changeAge(int newage);
}

//encapsulation(capsuling data like wrapping data & methods together as a single unit)
//fields private but having public getter and setter methods
class BankAccount extends AccountOperations implements AccountManagement {
    //public to directly print
    public int accId;
    //private then new methods to display create
    private String name;
    private double balance;
    private int age;

    //constructor()
    BankAccount(int accId, String name, double balance, int age) {
        this.accId = accId;
        this.name = name;
        this.balance = balance;
        this.age = age;
    }

    // Implementing the abstract method from AccountOperations
    @Override
    //hiding the implementation here
    //message format .format("id:{}",aaccId)
    public void accountSummary() {
        System.out.println(MessageFormat.format("id: {0}", accId));
        System.out.println(MessageFormat.format("name: {0}", name));
        System.out.println(MessageFormat.format("balance: {0}", balance));
        System.out.println(MessageFormat.format("age: {0}", age));
    }

    //creating new method method for private method access
    public String name() {
        return this.name;
    }

    //putting in money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("New Balance: " + balance);
    }

    //taking out money
    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    //as private putting getter setter methods(encapsulation)
    public double getBalance() {
        return balance;
    }

    public int getAccId() {
        return accId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAccId(int newaccId) {
        this.accId = newaccId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    //for all interface methods
    @Override
    public void changeId(int newAccId) {
        this.accId = newAccId;
        System.out.println("the new ID is :" + accId);
    }

    @Override
    public void changeAge(int newage) {
        this.age = newage;
        System.out.println("the updated age is: " + age);
    }

    @Override
    public void changeName(String newname) {
        this.name = newname;
        System.out.println("the name is: " + name);
    }
}
//POLYMORPHISM
//compiletime(method overloading)=multiple methods smae name diff para
//runtime(method overriding)=method in subclass same name,parameters in superclass
class Savings extends BankAccount{
    private double interestRate;
    Savings(int accId,String name,double balance,int age,double interestRate){
        //overrifding the super class id,name ,balnace,age  and adding interest rate
        super(accId,name,balance,age);
        this.interestRate=interestRate;
    }
    //we already created the accountsummary now add interest rate
    public void accountSummary(){
        super.accountSummary();
        System.out.println("Interest Rate: "+interestRate);
    }
}
//main class
public class Main {
    public static void main(String args[]) {
        BankAccount account1 = new BankAccount(123, "sristtii", 2345.23, 20);
        BankAccount account2 = new BankAccount(234, "hanini", 3427.78, 21);
        BankAccount account3 = new BankAccount(345, "tas", 2425.32, 23);
        BankAccount account4 = new BankAccount(456, "kirthik", 64574.32, 18);
        BankAccount account5 = new BankAccount(567, "arithro", 23244.23, 30);
        BankAccount account6 = new BankAccount(789, "anupraba", 67565.23, 12);

        System.out.println(account1.accId);
        System.out.println(account1.name());
        //calling abstract methods
        account1.getAccId();
        account1.setName("malya");
        account1.debit(200);
        account1.deposit(3000);
        account1.accountSummary();

        System.out.println();
        //the datas are rewritten for better understanfding so
        //created a list
        //using streams of better understanding

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(123, "sristtii", 2345.23, 20));
        accounts.add(new BankAccount(234, "harini", 3427.78, 21));
        accounts.add(new BankAccount(345, "tas", 2425.32, 23));
        accounts.add(new BankAccount(456, "kirthik", 64574.32, 18));
        accounts.add(new BankAccount(567, "arithro", 23244.23, 30));
        accounts.add(new BankAccount(789, "anupraba", 67565.23, 12));
        //no can use streams in accounts db
        List<Integer> accountIds = accounts.stream()
                .map(BankAccount::getAccId)
                .sorted()//takes out accountids
                .collect(Collectors.toList());
        //using for loop to handle ids
        for(BankAccount i:accounts){
            accountIds.add(i.getAccId());
        }
        Collections.sort(accountIds);//sorting account ids
        //using streams to store names
        List<String> accountOwners = accounts.stream()
                .map(BankAccount::getName)
                .collect(Collectors.toUnmodifiableList());
        // Using for loop to get account owners
        List<String> accountOwnerss = new ArrayList<>();
        for (BankAccount account : accounts) {
            accountOwnerss.add(account.getName());
        }
        //lets try to sort out ages
        List<Integer> agesofall = accounts.stream()
                .map(BankAccount::getAge)
                .collect(Collectors.toUnmodifiableList());
        // Using for loop to get ages
        List<Integer> agesofalll = new ArrayList<>();
        for (BankAccount account : accounts) {
            agesofalll.add(account.getAge());
        }
        //lets sum up the balances in the bank in total
        double balancestotal = accounts.stream()
                .map(BankAccount::getBalance)
                //sum() cant be used directly on double objects
                //instead use double use reduce()
                //(classname:: methodname)
                .reduce(0.0, Double::sum);

        System.out.println("total money in bank: " + balancestotal);
        System.out.println("ages of people: " + agesofall);
        System.out.println("names of ppl: " + accountOwners);
        System.out.println("account id numbers: "+accountIds);
        //going through polymorphism
        List<BankAccount> savings = new ArrayList<>();
        savings.add(new Savings(123, "sristtii", 2345.23, 20,2.3));
        savings.add(new Savings(234, "harini", 3427.78, 21,3.5));
        savings.add(new Savings(345, "tas", 2425.32, 23,5.7));
        //calling accountsummary for savings
        for(BankAccount i:savings){
            i.accountSummary();
            System.out.println("-------------------");
        }
    }
}