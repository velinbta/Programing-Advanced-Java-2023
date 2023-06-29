package StackIterator_03_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CustomIntegerStack stack = new CustomIntegerStack();

        while (!input.equals("END")) {

            String[] data = input.split(",*\\s+");
            String command = data[0];

            switch (command) {

                case "Push":
                    // Добавя оставащите елементи, след командата от data[], ако има такива
                    Integer[] numbersArr = Arrays.stream(Arrays.copyOfRange(data, 1, data.length))
                            .map(Integer::parseInt).toArray(Integer[]::new);

                    stack.push(numbersArr);

                    break;

                case "Pop":

                    stack.pop();

                    break;

                default:
                    throw new IllegalArgumentException("Unknown command " + command);

            }

            input = scanner.nextLine();
        }

        printElements(stack);
        printElements(stack);

    }

    private static void printElements(CustomIntegerStack stack) {
        stack.forEach(System.out::println);
    }

}
