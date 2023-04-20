package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic_04_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.equals("print")) {

                String output = Arrays.stream(numbersArr).mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));

                System.out.println(output);

            } else { // <- Ако не е принт

                IntUnaryOperator commandOperator = getCommandOperator(command);

                // Променям числата в масива в зависимост от командата и презаписвам масива
                numbersArr = Arrays.stream(numbersArr).map(commandOperator).toArray();

            }

            command = scanner.nextLine();

        }

    }

    private static IntUnaryOperator getCommandOperator(String command) {
        // В зависимост от командата ми връща IntUnaryOperator
        switch (command) {

            case "add":
                return n -> n + 1; // <- Добавя + 1 на всички числа
            case "multiply":
                return n -> n * 2; // <- Умножава по две всички числа
            case "subtract":
                return n -> n - 1; // <- Изважда - 1 от всички числа
            default:
                throw new IllegalArgumentException("Use:\nadd\nmultiply\nsubtract");

        }

    }

}
