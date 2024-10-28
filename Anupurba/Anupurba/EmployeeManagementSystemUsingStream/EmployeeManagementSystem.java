
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 50000),
            new Employee("Bob", 45, "Finance", 70000),
            new Employee("Charlie", 25, "Engineering", 60000),
            new Employee("David", 35, "Engineering", 80000),
            new Employee("Eve", 28, "HR", 45000),
            new Employee("Frank", 40, "Finance", 90000)
        );

        //To get the name of employee who is working in Engineering Department
        List<Employee> EngineerEmployee = employees.stream().filter(emp -> emp.getDepartment().
                                                equals("Engineering")).collect(Collectors.toList());
        System.out.println("List of employee works in Engineering Department is = \n "+ EngineerEmployee + "\n");
        


        //Get names of every employee of the company
        List<String> EmployeeName = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("Name of the Employees are - \n" + EmployeeName + "\n");
        

        //Sum of salary for all the Employee
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Total Expenses of company for employees salary is - \n" + totalSalary + "\n");
        


        //Grouping members by their department
        Map<String,List<Employee>> employeeDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees according to their department - \n" + employeeDepartment + "\n");
       
    }
}
