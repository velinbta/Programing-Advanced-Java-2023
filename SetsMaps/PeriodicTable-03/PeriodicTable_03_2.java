package SetsMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElementsSet = new TreeSet<>(); // <- По азбучен ред

        while (lines-- > 0) {

            String[] currentElementsArr = scanner.nextLine().split("\\s+");
            // Добавям текущите прочетени елементи
            Arrays.stream(currentElementsArr).forEach(e -> chemicalElementsSet.add(e));

        }

        chemicalElementsSet.forEach(e -> System.out.print(e + " "));

    }

}
