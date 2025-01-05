public class BookImplement implements  Book {
    private String title;
    private String author;
    private boolean available;

    //creating a constructor
    public BookImplement(String title, String author){
        this.title = title;
        this.author = author;
        this.available = true;
    }

    @Override
    public String getTitle(){
        return title;
    }
    @Override
    public String getAuthor(){
        return author;
    }
    @Override
    public boolean isAvailable(){
        return available;
    }
    @Override
    public void setAvailable(boolean available){
        this.available = available;
    }
}
