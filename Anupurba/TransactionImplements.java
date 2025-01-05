
import java.time.LocalDate;

public class TransactionImplements implements Transaction {
    private Member member;
    private Book book;
    private LocalDate issueDate;
    private LocalDate returnDate;

    //constructor
    public TransactionImplements(Member member, Book book){
        this.member = member;
        this.book = book;
        this.issueDate = LocalDate.now();
        this.returnDate = issueDate.plusWeeks(2);
    }

    //Borrow Book
    @Override
    public void borrowBook(Member member,Book book){
        if(book.isAvailable()){
            this.member = member;
            this.book = book;
            book.setAvailable(false);
            System.out.println(member.getName() + " borrowed " + book.getTitle() +
                               " on " + issueDate + ". Return by " + returnDate + ".");
        } else {
            System.out.println(book.getTitle() + " is currently unavailable.");
        }
        
        //member.borrowBook(book);
    }

    //Return Book
    @Override
    public void returnBook(Member member,Book book){
        if(this.member.equals(member) && this.book.equals(book)){
            book.setAvailable(true);
            System.out.println(member.getName() + " returned " + book.getTitle() +
                               " on " + LocalDate.now() + ".");
        }
        else {
            System.out.println(member.getName() + " did not borrow " + book.getTitle());
        }
    }

    //Issue Date
    @Override
    public LocalDate getIssuDate(){
        return issueDate;
    }

    //Return Date
    @Override
    public LocalDate isReturnDate(){
        return returnDate;
    }

    //Is Return Due
    @Override
    public boolean isreturnDue(){
        LocalDate today = LocalDate.now();
        return today.isEqual(returnDate) || today.isAfter(returnDate);
    }
    
    @Override
    public Book getBook() { // Add this method
        return book;
    }

}
