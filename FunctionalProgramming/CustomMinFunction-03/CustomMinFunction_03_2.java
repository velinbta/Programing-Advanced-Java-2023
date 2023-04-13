package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03_2 {
    public static void main(String[] args) {

        int[] numArr = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minFunc = arr -> Arrays.stream(arr)
                .min().orElse(-1); // <- Намира най-малкото число

        int min = minFunc.apply(numArr);

        System.out.println(min);

    }

}
