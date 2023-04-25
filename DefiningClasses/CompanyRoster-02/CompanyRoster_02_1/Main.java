package CompanyRoster_02_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {

            String[] data = scanner.nextLine().split("\\s+");
            int arrayLength = data.length;

            if (arrayLength < 4 || arrayLength > 6) {
                throw new IllegalArgumentException("Invalid data"); // <- При по-малко от 4 или повече от 6
            }

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee; // <- В зависимост от размера на конструктора

            if (arrayLength == 6) {

                String email = data[4];
                int age = Integer.parseInt(data[5]);

                employee = new Employee(name, salary, position, department, email, age); // <- Пълен размер

                Employee.employeeList.add(employee);

            } else if (arrayLength == 5) {

                try {

                    int age = Integer.parseInt(data[4]); // <- Ако е възраст
                    employee = new Employee(name, salary, position, department, age);

                } catch (NumberFormatException e) {

                    String email = data[4]; // <- Ако не е възраст
                    employee = new Employee(name, salary, position, department, email);

                }

                Employee.employeeList.add(employee);

            } else { // <- При най-малкия задължителен конструктор от 4 елемента

                employee = new Employee(name, salary, position, department);
                Employee.employeeList.add(employee);

            }

        }

        String highestPaidDepartment = getHighestPaidDepartment();

        System.out.printf("Highest Average Salary: %s\n", highestPaidDepartment);
        // Премахвам всички, които не са от най-високо платения отдел, сортирам ги в низходящ ред и принтирам
        Employee.employeeList.stream().filter(employee -> employee.getDepartment().equals(highestPaidDepartment))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }

    private static String getHighestPaidDepartment() {
        // Връща най-високо платения отдел
        Map<String, Double> departmentSalaryMap = new HashMap<>();

        Employee.employeeList.forEach(employee -> {
            // Събирам в Map заплатите на всички служителите по отдели
            String department = employee.getDepartment();
            double salary = employee.getSalary();
            departmentSalaryMap.putIfAbsent(department, 0.0);
            departmentSalaryMap.put(department, departmentSalaryMap.get(department) + salary);

        });

        return departmentSalaryMap.entrySet().stream() // <- Сортирам ги и взимам отдела с най-висока заплата
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(Map.Entry::getValue)))
                .iterator().next().getKey();

    }

}