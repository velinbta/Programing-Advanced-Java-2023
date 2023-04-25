package OpinionPoll_01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Set<Person> personSet = new HashSet<>();

        IntStream.range(0, lines).forEach(line -> {
            // Добавя всички хора в Set
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            personSet.add(person);
        });

        // Филтрира тези над 30 и сравнява по имена
        personSet.stream().filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(person -> person.getName()))
                .forEach(System.out::println);

    }

}
