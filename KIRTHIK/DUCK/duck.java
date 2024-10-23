
public class duck implements Flyable, Swimmable, Animal {

    @Override
    public void eat() {
        System.out.println("The duck is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("The duck is sleeping.");
    }

    @Override
    public void fly() {
        System.out.println("The duck is flying.");
    }

    @Override
    public void swim() {
        System.out.println("The duck is swimming.");
    }

    public static void main(String[] args) {
        duck duck = new duck();     
        duck.eat();
        duck.sleep();
        duck.takeOff();  
        duck.fly();
        duck.swim();
        
    }
}