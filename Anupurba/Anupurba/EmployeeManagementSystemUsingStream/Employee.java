class Employee{

    private String name;
    private int age;
    private double  salary;
    private  String department;

    // Constructor
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    //Use of getter methods...
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
    public double  getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", department=" + department + "]";
    }

    public String getDepartment() {
        return department;
    }

    
}
