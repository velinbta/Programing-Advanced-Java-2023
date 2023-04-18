package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class CustomComparator_08_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Integer[] naturalOrderSorted = Arrays.stream(input.split("\\s+")).map(Integer::parseInt)
                .sorted().toArray(Integer[]::new);

        Function<Integer, Boolean> evenFirst = n -> n % 2 != 0; // <- Първо четните числа, след това нечетните

        Arrays.stream(naturalOrderSorted).sorted(Comparator.comparing(evenFirst))
                .forEach(n -> System.out.print(n + " ")); // <- Сортирам и принтирам

    }

}
