package Abstract_ex;
public abstract class Movie {

    public abstract String getMovieName();

    public abstract void playMovie();

    public void stopMovie() {
        System.out.println("Stopping the movie.");
    }

    public void showMovieInfo() {
        System.out.println("This is a great movie!");
    }

    protected abstract void description();
}