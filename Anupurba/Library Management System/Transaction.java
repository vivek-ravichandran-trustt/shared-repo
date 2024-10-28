import java.time.LocalDate;

public interface  Transaction {
    public void borrowBook(Member member, Book book);
    public void returnBook(Member member, Book book);
    LocalDate getIssuDate();
    LocalDate isReturnDate();
    boolean isreturnDue();
    Book getBook();
}
