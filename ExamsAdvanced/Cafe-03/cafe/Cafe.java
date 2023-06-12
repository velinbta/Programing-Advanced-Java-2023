package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Cafe {

    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (verifyCapacity()) { // <- Валидира, ако има място - добавя
            this.employees.add(employee);
            this.capacity--;
        }
    }

    public boolean removeEmployee(String name) {
        if (this.employees.stream().anyMatch(employee -> employee.getName().equals(name))) {
            this.capacity++; // <- Ако има служител, премахва и увеличава капацитета
        }
        return this.employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        // Най-възрастния
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).
                orElseThrow(() -> new NoSuchElementException("Employee collection is empty!"));
    }

    public Employee getEmployee(String name) {
        // Намира служител по име
        return this.employees.stream().filter(employee -> employee.getName().equals(name)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Employee does not exist!"));
    }

    public int getCount() {
        // Връща броя на служителите
        return this.employees.size();
    }

    public String report() {

        StringBuilder report = new StringBuilder();
        report.append(String.format("Employees working at Cafe %s:", getName()));
        report.append(System.lineSeparator());

        IntStream.range(0, this.employees.size()).forEach(index -> {
            report.append(employees.get(index).toString());
            if (index != this.employees.size() - 1) {
                report.append(System.lineSeparator());
            }
        });

        return report.toString();
    }

    private boolean verifyCapacity() {
        // Проверява, дали в кафето има място за служители
        return this.capacity > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
