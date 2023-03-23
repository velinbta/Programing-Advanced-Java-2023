package SetsMaps;

import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable_03_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElementsSet = new TreeSet<>(); // <- По азбучен ред

        for (int i = 0; i < lines; i++) {

            List<String> currentElementsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .collect(Collectors.toList());
            // Добавям текущите прочетени елементи
            chemicalElementsSet.addAll(currentElementsList);

        }

        chemicalElementsSet.forEach(e -> System.out.print(e + " "));

    }

}
