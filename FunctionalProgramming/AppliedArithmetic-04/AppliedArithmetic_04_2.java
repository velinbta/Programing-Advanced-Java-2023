package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetic_04_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            // Модифицирам списъка според командата
            numList = getModifiedListAccordingToCommand(command, numList);

            command = scanner.nextLine();
        }

    }

    private static List<Integer> getModifiedListAccordingToCommand(String command, List<Integer> numList) {

        switch (command) {

            case "add":
                // Прибавя на всяко число + 1
                return numList.stream().map(n -> n + 1).collect(Collectors.toList());

            case "multiply":
                // Умножава всяко число по две
                return numList.stream().map(n -> n * 2).collect(Collectors.toList());

            case "subtract":
                // Изважда от всяко число - 1
                return numList.stream().map(n -> n - 1).collect(Collectors.toList());

            case "print":
                // Принтира списъка до този момент
                printText(numList);
                return numList;

            default:

                throw new IllegalArgumentException("Unknown command " + command);

        }

    }

    private static void printText(List<Integer> numList) {
        // Принтира списъка до момента
        System.out.println(numList.stream()
                .map(String::valueOf).collect(Collectors.joining(" ")));

    }

}
