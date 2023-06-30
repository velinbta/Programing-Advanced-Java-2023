package Froggy_04_2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lake lake = new Lake();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            Arrays.stream(input.split(",\\s*")).mapToInt(Integer::parseInt)
                    .forEach(lake::addJump); // <- Добавям скоковете в езерото

            input = scanner.nextLine();
        }

        IntStream.range(0, lake.size()).filter(index -> index % 2 == 0) // <- Четни индекси
                .forEach(index -> {

                    System.out.print(lake.getJump(index));
                    if (isCommandNeeded(lake, index)) {
                        printCommandAndSpace();
                    }

                });

        if (!lake.isEmpty() && lake.size() > 1) { // <- Нечетни индекси

            printCommandAndSpace();

            IntStream.range(0, lake.size()).filter(index -> index % 2 != 0)
                    .forEach(index -> {

                        System.out.print(lake.getJump(index));
                        if (isCommandNeeded(lake, index)) {
                            printCommandAndSpace();
                        }

                    });

        }

    }

    private static boolean isCommandNeeded(Lake lake, int index) {
        // Ако трябва разделител - запетая
        return index != lake.size() - 1 && index != lake.size() - 2;
    }

    private static void printCommandAndSpace() {
        System.out.print(", ");
    }

}
