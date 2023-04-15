package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetic_04_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {

                case "add":
                    // Прибавя на всяко число + 1
                    numArr = Arrays.stream(numArr).map(n -> n + 1).toArray();

                    break;

                case "multiply":
                    // Умножава всяко число по две
                    numArr = Arrays.stream(numArr).map(n -> n * 2).toArray();

                    break;

                case "subtract":
                    // Изважда от всяко число - 1
                    numArr = Arrays.stream(numArr).map(n -> n - 1).toArray();

                    break;

                case "print":
                    // Принтира масива до момента
                    String output = Arrays.stream(numArr).mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "));

                    System.out.println(output);

                    break;

            }

            command = scanner.nextLine();

        }

    }

}
