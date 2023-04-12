package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SortEvenNumbers_01_3 {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();

        String[] evenNumbers = Arrays.stream(input.split(",\\s+")).mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0).mapToObj(String::valueOf).toArray(String[]::new); // <- Четни числа

        String[] sortedNumbers = Arrays.stream(evenNumbers).mapToInt(Integer::parseInt).sorted()
                .mapToObj(String::valueOf).toArray(String[]::new); // <- Четни, сортирани в нарастващ ред

        System.out.println(String.join(", ", evenNumbers));
        System.out.println(String.join(", ", sortedNumbers));

    }

}
