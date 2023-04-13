package FunctionalProgramming;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int lowerBound = range[0];
        int upperBound = range[1];

        Set<Integer> integerSet = new LinkedHashSet<>();
        // Добавям всички числа в диапазона
        IntStream.range(lowerBound, upperBound + 1).forEach(integerSet::add);

        String condition = scanner.nextLine();

        switch (condition) {
            // Филтрирам и принтирам според условието
            case "odd":

                integerSet.stream().filter(n -> n % 2 != 0).forEach(n -> System.out.print(n + " "));

                break;

            case "even":

                integerSet.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));

                break;

            default:
                throw new IllegalArgumentException("\nPossible condition is:\nodd\neven");

        }

    }

}
