package CompanyRoster_02_2;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {

        this.name = name;
        employeeList = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public double calculateAverageSalary() {
        // Намира средно аритметично заплатите на служителите
        return employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(-1);
    }

}
