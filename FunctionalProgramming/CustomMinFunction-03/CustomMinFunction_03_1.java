package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03_1 {
    public static void main(String[] args) {

        Integer[] numArr = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer> minFunc = arr -> Arrays.stream(arr) // <- Намира най-малкото число
                .mapToInt(n -> n).min().orElse(-1);

        int min = minFunc.apply(numArr);

        System.out.println(min);

    }

}
