package CompanyRoster_02_1;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;

    private String email;
    private int age;

    public static List<Employee> employeeList = new ArrayList<>();

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, getSalary(), this.email, this.age);
    }

}
