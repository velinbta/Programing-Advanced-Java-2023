package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers_02_1 {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();
        int[] numbersArr = Arrays.stream(input.split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Long> count = x -> Arrays.stream(x).count(); // <- Брой числа
        Function<int[], Integer> sum = x -> Arrays.stream(x).sum(); // <- Сума числа

        System.out.println("Count = " + count.apply(numbersArr));
        System.out.println("Sum = " + sum.apply(numbersArr));

    }

}
