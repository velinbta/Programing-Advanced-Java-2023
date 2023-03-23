package SetsMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSetLength = scanner.nextInt(); // <- Редове за първи Set
        int secondSetLength = scanner.nextInt(); // <- Редове за втори Set

        // Запълвам двата Set
        Set<String> firstSet = readAndFillInLinkedHashSetByLength(scanner, firstSetLength);
        Set<String> secondSet = readAndFillInLinkedHashSetByLength(scanner, secondSetLength);

        firstSet.forEach(e -> {
            // Ако елементът се съдържа и в другия Set го принтирам
            if (secondSet.contains(e)) {
                System.out.print(e + " ");
            }

        });

    }

    private static Set<String> readAndFillInLinkedHashSetByLength(Scanner scanner, int length) {
        // Попълва LinkedHashSet по зададени редове
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < length; i++)
            set.add(scanner.next());

        return set;
    }

}
