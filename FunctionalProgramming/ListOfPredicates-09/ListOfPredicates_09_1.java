package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates_09_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperBound = Integer.parseInt(scanner.nextLine());

        Integer[] divisibleArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        List<Integer> allNumbersSet = IntStream.rangeClosed(1, upperBound).boxed()
                .collect(Collectors.toList()); // <- От 1 до горната граница включително

        BiPredicate<Integer, Integer> isDivisible = (n, division) -> n % division == 0;

        // Премахвам всички, които не се делят на числата от divisibleArray
        Arrays.stream(divisibleArray).forEach(division ->
                allNumbersSet.removeIf(n -> !isDivisible.test(n, division)));

        allNumbersSet.forEach(n -> System.out.print(n + " "));

    }

}
