import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        //Transaction transaction=new TransactionImplements();

        //sample Data
        books.add(new BookImplement("1984", "George Orwell"));
        books.add(new BookImplement("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new BookImplement("To Kill a Mockingbird", "Harper Lee"));


        //Menu
        while (true) { 
            System.out.println("Library Management System");
            System.out.println("1.Regiter Member");
            System.out.println("2.Borrow Book");
            System.out.println("3.Return Book");
            System.out.println("4.Display Borrowed books");
            System.out.println("5. Check Due Books");
            System.out.println("6.Exit");
            System.out.println("Choose an Option = ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                //Register Member
                case 1:
                    System.out.println("Enter member name-");
                    String memberName = sc.nextLine();
                    members.add(new MemberImplements(memberName));
                    System.out.println("Member registered - " +memberName);
                    break;

                //Borrow Books
                case 2:
                    System.out.println("Enetr members name - ");
                    String borrowMemberName = sc.nextLine();
                    Member borrowMember = findMember(members,borrowMemberName);

                    if(borrowMember != null){
                        System.out.println("Enter book title:");
                        String bookTitle = sc.nextLine();
                        Book bookToBorrow = findBooks(books,bookTitle);
                        if(bookToBorrow != null){
                            TransactionImplements transaction = new TransactionImplements(borrowMember, bookToBorrow);
                            transaction.borrowBook(borrowMember, bookToBorrow);
                        }else{
                            System.out.println("Book is not found");
                        }
                    }
                    break;

                //Return Book
                case 3:
                    System.out.println("Enter the member name -");
                    String returnBookMember = sc.nextLine();
                    Member returnMember = findMember(members, returnBookMember);

                    if(returnMember!=null){
                        System.out.println("Enter the book name - ");
                        String returnBookName = sc.nextLine();
                        Book bookToReturn = findBooks(books, returnBookName);

                        if(bookToReturn != null){
                            TransactionImplements transaction = new TransactionImplements(returnMember, bookToReturn);
                            transaction.returnBook(returnMember, bookToReturn);
                        }
                        else{
                            System.out.println("Book is not found");
                        } 
                    }
                    else{
                        System.out.println("Member is not found.");
                    }
                    break;

                //Display borrow books
                case 4:
                    System.out.println("Please enter the member name -");
                    String displayMemberName = sc.nextLine();
                    Member displayMember= findMember(members, displayMemberName);
                    if(displayMember != null){
                        displayMember.displayBorrowBooks();
                    }
                    else{
                        System.out.println("Member is not found");
                    }
                    break;
                
                //Due Date
                case 5:
                    System.out.println("Please Enter the member name - ");
                    String dueMemberName = sc.nextLine();
                    Member dueMember = findMember(members, dueMemberName);
                    if(dueMember != null){
                        ((MemberImplements)dueMember).checkDueBooks(); //upcasting
                    }
                    else{
                        System.out.println("Member is not found");
                    }
                    break;
                    
                //Exit
                case 6:
                    System.out.println("Exiting the System");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option..Please choose the right option..!");
            
            }
        }
    }
    private static Member findMember(List<Member> members, String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }
    private static Book findBooks(List<Book> books,String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }
}
