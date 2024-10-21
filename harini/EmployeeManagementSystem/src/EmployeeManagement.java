import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Interface for payment calculation
interface Payable {
    double calculateSalary();
}

// Abstract class Employee implements Payable
abstract class Employee implements Payable {
    private String name;
    private int id;
    private double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract String getRole();

    public void showDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Role: " + getRole() + ", Salary: " + calculateSalary());
    }
}

// Developer class extends Employee
class Developer extends Employee {
    public Developer(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + 5000;
    }

    @Override
    public String getRole() {
        return "Developer";
    }
}

// Manager class extends Employee
class Manager extends Employee {
    public Manager(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + 10000;
    }

    @Override
    public String getRole() {
        return "Manager";
    }
}

// Intern class extends Employee
class Intern extends Employee {
    public Intern(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public String getRole() {
        return "Intern";
    }
}

// Main class to manage employees
public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Developer("Sristi", 01, 50000));
        employees.add(new Manager("Vivek", 02, 70000));
        employees.add(new Intern("Harini", 03, 40000));

        employees.forEach(Employee::showDetails);

        double totalSalaries = employees.stream()
                .mapToDouble(Employee::calculateSalary)
                .sum();

        System.out.println("\nTotal Salaries: " + totalSalaries);
    }
}
