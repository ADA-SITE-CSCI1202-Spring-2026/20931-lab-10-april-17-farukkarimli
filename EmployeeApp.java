import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    // Constructor
    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeApp {
    public static void main(String[] args) {

        // Create list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Faruk", "Karimli", 1200));
        employees.add(new Employee("Ali", "Mammadov", 900));
        employees.add(new Employee("Leyla", "Aliyeva", 1500));

        // Lambda: format employee card
        Function<Employee, String> formatCard =
                e -> "Name: " + e.getLastName() + ", " + e.getFirstName()
                        + " - Salary: $" + e.getSalary();

        // Method reference: get salary
        Function<Employee, Double> salaryPicker = Employee::getSalary;

        // Iterate and print
        for (Employee e : employees) {
            System.out.println(formatCard.apply(e));
            System.out.println("Salary only: $" + salaryPicker.apply(e));
            System.out.println();
        }
    }
}