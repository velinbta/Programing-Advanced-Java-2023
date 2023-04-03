package SetsMaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PeriodicTable_03_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> compoundsSet = new HashSet<>();
        for (int i = 0; i < numberOfCompounds; i++) {
            // Добавям уникалните елементи от всеки прочетен ред
            Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> compoundsSet.add(e));

        }

        compoundsSet.stream().sorted().forEach(e -> System.out.print(e + " ")); // <- По азбучен ред

    }

}
