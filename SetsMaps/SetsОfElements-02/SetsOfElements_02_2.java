package SetsMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int firstSetLength = Integer.parseInt(input.split("\\s+")[0]); // <- Редове за първи Set
        int secondSetLength = Integer.parseInt(input.split("\\s+")[1]); // <- Редове за втори Set

        Set<Integer> firstSet = readAndFillInLinkedHashSetByLength(scanner, firstSetLength);
        Set<Integer> secondSet = readAndFillInLinkedHashSetByLength(scanner, secondSetLength);

        // Създавам Set за повтарящите се елементи, който първоначално става равен на първия Set
        Set<Integer> repeatingElementsSet = new LinkedHashSet<>(firstSet);
        repeatingElementsSet.retainAll(secondSet); // <- И премахвам всички елементи, които ги няма във втория Set

        repeatingElementsSet.forEach(e -> System.out.print(e + " "));

    }

    private static Set<Integer> readAndFillInLinkedHashSetByLength(Scanner scanner, int length) {
        // Попълва LinkedHashSet по зададени редове
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < length; i++)
            set.add(Integer.parseInt(scanner.nextLine()));

        return set;
    }

}
