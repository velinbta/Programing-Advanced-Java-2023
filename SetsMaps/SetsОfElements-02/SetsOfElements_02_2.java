package SetsMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengthArr = readIntegerArray(scanner);
        int firstSetLength = lengthArr[0]; // <- Редове за първи Set
        int secondSetLength = lengthArr[1]; // <- Редове за втори Set

        // Запълвам двата Set
        Set<Integer> firstSet = readAndFillInLinkedHashSetByLength(scanner, firstSetLength);
        Set<Integer> secondSet = readAndFillInLinkedHashSetByLength(scanner, secondSetLength);

        Set<Integer> repeatingElementsSet = new LinkedHashSet<>(); // <- Повтарящите се елементи от двата Set

        firstSet.forEach(num -> {
            // Ако елементът се съдържа и в другия Set го добавям в този с повтарящите се елементи
            if (secondSet.contains(num)) {
                repeatingElementsSet.add(num);
            }

        });

        repeatingElementsSet.forEach(n -> System.out.print(n + " "));

    }

    private static int[] readIntegerArray(Scanner scanner) {
        // Прочита int[]
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(n -> Integer.parseInt(n)).toArray();

    }

    private static Set<Integer> readAndFillInLinkedHashSetByLength(Scanner scanner, int length) {
        // Попълва LinkedHashSet по зададени редове
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < length; i++)

            set.add(Integer.parseInt(scanner.nextLine()));

        return set;
    }

}
