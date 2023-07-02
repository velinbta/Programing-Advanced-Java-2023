package StrategyPattern_06_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        // Comparator - дължина на името [при равенство - първата буква (case insensitive)]
        Set<Person> sortedNameLengthPersonSet = new TreeSet<>(new PersonNameLengthComparator());
        // Comparator - възраст
        Set<Person> sortedAgePersonSet = new TreeSet<>(new PersonAgeComparator());

        while (lines-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            sortedNameLengthPersonSet.add(person);
            sortedAgePersonSet.add(person);

        }

        sortedNameLengthPersonSet.forEach(System.out::println);
        sortedAgePersonSet.forEach(System.out::println);

    }

}
