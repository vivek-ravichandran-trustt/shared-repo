package Abstract_ex;
public class Main {
    public static void main(String[] args) {
        
        Movie movie1 = new Inception();
        Movie movie2 = new Titanic();
        
        movie1.playMovie();
        movie1.showMovieInfo();
        movie1.description();  
        movie1.stopMovie();

        System.out.println("-------------------");

        movie2.playMovie();
        movie2.showMovieInfo();
        movie2.description();  
        movie2.stopMovie();
    }
}