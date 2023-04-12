package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01_2 {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();

        List<String> evenNumbers = Arrays.stream(input.split(",\\s+")).map(Integer::parseInt)
                .filter(n -> n % 2 == 0).map(String::valueOf).collect(Collectors.toList()); // <- Четни числа

        List<String> sortedNumbers = evenNumbers.stream().map(Integer::parseInt).sorted()
                .map(String::valueOf).collect(Collectors.toList()); // <- Четни, сортирани в нарастващ ред

        System.out.println(String.join(", ", evenNumbers));
        System.out.println(String.join(", ", sortedNumbers));

    }

}
