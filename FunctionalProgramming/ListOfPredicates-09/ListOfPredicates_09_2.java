package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates_09_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperBound = Integer.parseInt(scanner.nextLine());

        Set<Integer> divisibleSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toSet());

        List<Integer> allNumbersSet = IntStream.rangeClosed(1, upperBound).boxed()
                .collect(Collectors.toList()); // <- От 1 до горната граница включително

        // Премахвам всички, които не се делят на числата от divisibleSet
        divisibleSet.forEach(division -> allNumbersSet.removeIf(n -> n % division != 0));

        allNumbersSet.forEach(n -> System.out.print(n + " "));

    }

}
