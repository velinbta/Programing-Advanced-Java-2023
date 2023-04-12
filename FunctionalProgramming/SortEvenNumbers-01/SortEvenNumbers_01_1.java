package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01_1 {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();

        List<Integer> evenNumbers = Arrays.stream(input.split(",\\s+")) // <- Четни числа
                .map(Integer::parseInt).filter(n -> n % 2 == 0).collect(Collectors.toList());

        // Четни, сортирани в нарастващ ред
        List<Integer> sortedNumbers = evenNumbers.stream().sorted().collect(Collectors.toList());

        System.out.println(evenNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(sortedNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }

}
