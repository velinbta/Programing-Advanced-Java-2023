package ComparingObjects_05_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = readAndAddPeople(scanner);

        int index = Integer.parseInt(scanner.nextLine()); // <- Индекс на човека от списъка

        int matches = findMatches(people, index); // <- Съвпадения

        int noneMatches = Math.abs(matches - people.size());

        int total = people.size();

        String output = matches != 0
                ? String.format("%d %d %d", matches, noneMatches, total)
                : "No matches";

        System.out.println(output);

    }

    private static List<Person> readAndAddPeople(Scanner scanner) {
        // Прочита и добавя хората в списък
        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] data = input.split("\\s+");

            Arrays.stream(data).map(p -> new Person(data[0], Integer.parseInt(data[1]), data[2]))
                    .findFirst().ifPresent(people::add);

            input = scanner.nextLine();
        }

        return people;
    }

    private static int findMatches(List<Person> people, int index) {
        // Връща, колко хора съвпадат с търсения човек
        int matches = 0;

        if (!people.isEmpty() && index >= 0 && index < people.size()) {

            Person neededPerson = people.get(index);
            matches = (int) people.stream().filter(p -> p.compareTo(neededPerson) == 0).count();

        }

        return matches;
    }

}
