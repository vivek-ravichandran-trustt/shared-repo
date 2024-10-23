package Encapsulation;
import java.util.*;
class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        person person=new person("kirthik",21);

        System.out.println(person.getName());
        System.out.println(person.getAge());
        person.setName("Leo");
        person.setAge(89);
        System.out.println(person.getName());
        System.out.println(person.getAge());
                
    }
        
}
