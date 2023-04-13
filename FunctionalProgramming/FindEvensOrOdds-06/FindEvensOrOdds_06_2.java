package FunctionalProgramming;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String condition = scanner.nextLine();

        int lowerBound = range[0];
        int upperBound = range[1];

        Set<Integer> integerSet = new LinkedHashSet<>();
        // Добавям всички числа в диапазона
        IntStream.range(lowerBound, upperBound + 1).forEach(integerSet::add);

        // Взимам Predicate според условието - четни, нечетни
        Predicate<Integer> filterByCondition = getFilterByCondition(condition);

        integerSet.stream().filter(filterByCondition).forEach(n -> System.out.print(n + " "));

    }

    private static Predicate<Integer> getFilterByCondition(String condition) {
        // Получавам Predicate според условието
        switch (condition) {

            case "odd":

                return n -> n % 2 != 0;

            case "even":

                return n -> n % 2 == 0;

            default:
                throw new IllegalArgumentException("Unknown command: " +
                        condition + "\nPossible commands are:\nodd\neven");

        }

    }

}
