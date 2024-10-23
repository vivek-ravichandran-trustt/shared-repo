package Encapsulation;

public class person {
    private String Name;
    private int age;

    public person(String Name,int age){
        this.Name=Name;
        this.age=age;
    }
    public String getName(){
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age<60&& age>=18){
            this.age=age;
        }
        else{
            System.out.println("Age should be between 18-60");
        }
    }
}
