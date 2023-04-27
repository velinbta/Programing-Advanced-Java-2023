package CompanyRoster_02_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeesCount = Integer.parseInt(scanner.nextLine());

        List<Department> departmentList = new ArrayList<>();

        for (int i = 0; i < employeesCount; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");

            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String employeeDepartment = employeeData[3];

            int arrayLength = employeeData.length;

            Employee employee = null;
            switch (arrayLength) {

                case 6: // <- Конструктор с всички елементи

                    String email = employeeData[4];
                    int age = Integer.parseInt(employeeData[5]);

                    employee = new Employee(name, salary, position, employeeDepartment, email, age);
                    break;

                case 5:

                    employee = employeeData[4].contains("@") // <- Ако съдържа @ - email, ако не - age
                            ? new Employee(name, salary, position, employeeDepartment, employeeData[4])
                            : new Employee(name, salary, position, employeeDepartment, Integer.parseInt(employeeData[4]));

                    break;

                case 4: // <- Всички четири задължителни

                    employee = new Employee(name, salary, position, employeeDepartment);
                    break;

            }

            boolean departmentExists = departmentList.stream().anyMatch(department
                    -> department.getName().equals(employeeDepartment));

            // Добавям имената само уникалните имена на отделите
            if (!departmentExists) {
                Department department = new Department(employeeDepartment);
                departmentList.add(department);
            }

            // За всеки отдел добавям списък със служителите, отговярящи на отдела
            Department currentDepartment = departmentList.stream()
                    .filter(department -> department.getName().equals(employeeDepartment))
                    .findFirst().get();

            currentDepartment.getEmployeeList().add(employee);

        }

        // Намира най-високо платения отдел, като сравнява средно аритметично заплатите за всички отдели
        Department highestPaidDepartment = departmentList.stream().
                max(Comparator.comparingDouble(Department::calculateAverageSalary)).get();

        printSortedDepartmentOutput(highestPaidDepartment);

    }

    private static void printSortedDepartmentOutput(Department highestPaidDepartment) {
        // Сортира отдела по заплати и принтира изходните данни
        System.out.printf("Highest Average Salary: %s\n", highestPaidDepartment.getName());
        highestPaidDepartment.getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }

}
