package Abstract_ex;

public class Titanic extends Movie{

    @Override
    public String getMovieName() {
        return "Titanic";
    }

    @Override
    public void playMovie() {
        System.out.println("Playing the movie: " + getMovieName());
    }

    public void description() {
        System.out.println("Showing the grand ship Titanic...");
    }
}