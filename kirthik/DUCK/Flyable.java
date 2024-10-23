public interface Flyable {
    void fly();

    default void takeOff() {
        System.out.println("Taking off into the sky!");
    }
}