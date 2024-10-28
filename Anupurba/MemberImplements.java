import java.util.*;
public class MemberImplements implements Member{
    private String name;
    private List<TransactionImplements> transactions;

    //create a constructor
    public MemberImplements(String name){
        this.name = name;
        this.transactions = new ArrayList<>();
    }
    @Override
    public String getName(){
        return name;
    }

    //Borrow Book
    @Override
    public void borrowBook(Book book){
        TransactionImplements transaction = new TransactionImplements(this,book);
        transaction.borrowBook(this, book);
        transactions.add(transaction);
    }

    //Return Book
    @Override
    public void returnBook(Book book) {
        for (TransactionImplements transaction : transactions) {
            if (transaction.getBook().equals(book)) {
                transaction.returnBook(this, book);
                transactions.remove(transaction);
                return;
            }
        }
        System.out.println(name + " did not borrow " + book.getTitle());
    }

    //Display Borrow Books
    @Override
    public void displayBorrowBooks() {
        System.out.println(name + "'s Borrowed Books:");
        for (TransactionImplements transaction : transactions) {
            System.out.println("- " + transaction.getBook().getTitle() + 
                               " | Issued on: " + transaction.getIssuDate() +
                               " | Due on: " + transaction.isReturnDate());
        }  
    }

    //Check Due Books
    @Override
    public void checkDueBooks(){
        System.out.println(name+"'s due Alerts");
        for(TransactionImplements transaction : transactions){
            if(transaction.isreturnDue()){
                System.out.println("Reminder: " + transaction.getBook().getTitle() + 
                                   " is due for return on " + transaction.isReturnDate() + ".");
            }
        }
    }
}
