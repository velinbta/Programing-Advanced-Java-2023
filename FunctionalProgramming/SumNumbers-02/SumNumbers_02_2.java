package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers_02_2 {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();

        Function<String, Integer> count = n -> Arrays.stream(input.split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray().length; // <- Брой числа

        Function<String, Integer> sum = n -> Arrays.stream(input.split(",\\s+"))
                .mapToInt(Integer::parseInt).sum(); // <- Сума числа

        System.out.printf("Count = %d\n", count.apply(input));
        System.out.printf("Sum = %d\n", sum.apply(input));

    }

}
