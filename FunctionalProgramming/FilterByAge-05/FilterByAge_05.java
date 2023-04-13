package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterByAge_05 {

    private static class Person {

        private String name;
        private int age;

        private Person(String name, int age) {

            this.name = name;
            this.age = age;

        }

        private int getAge() {
            return age;
        }

        private String getName() {
            return name;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();
        while (lines-- > 0) {

            // Извеждам информацията и добавям хората в списъка
            String[] info = scanner.nextLine().split(",\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            Person currentPerson = new Person(name, age);
            personList.add(currentPerson);

        }

        // Условия за възраст, години и формат на принтиране
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        List<Person> filteredList = getAgeFilteredArrayList(personList, condition, age);
        printAccordingToTheFormat(filteredList, format);

    }

    private static List<Person> getAgeFilteredArrayList(List<Person> personList, String condition, int age) {
        // Връща нов списък с филтрирани хора според условие за възраст и години
        switch (condition) {

            case "older":
                return personList.stream().filter(p -> p.getAge() >= age).collect(Collectors.toList());
            case "younger":
                return personList.stream().filter(p -> p.getAge() <= age).collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("\nPossible valid arguments are:\nolder\nyounger");
        }

    }

    private static void printAccordingToTheFormat(List<Person> filteredList, String format) {
        // Принтира според формата
        switch (format) {

            case "name":
                filteredList.forEach(p -> System.out.printf("%s\n", p.getName()));
                break;
            case "age":
                filteredList.forEach(p -> System.out.printf("%d\n", p.getAge()));
                break;
            case "name age":
                filteredList.forEach(p -> System.out.printf("%s - %d\n", p.getName(), p.getAge()));
                break;
            default:
                throw new IllegalArgumentException
                        ("\nPossible valid arguments are:\nname age\nname\nage\n");
        }

    }

}
