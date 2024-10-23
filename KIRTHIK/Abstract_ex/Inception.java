package Abstract_ex;
public class Inception extends Movie {

    @Override
    public String getMovieName() {
        return "Inception";
    }

    @Override
    public void playMovie() {
        System.out.println("Playing the movie: " + getMovieName());
    }

    public void description() {
        System.out.println("Exploring multiple dream levels...");
    }
}