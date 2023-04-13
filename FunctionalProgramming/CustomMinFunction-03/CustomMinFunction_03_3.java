package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03_3 {
    public static void main(String[] args) {

        Set<Integer> integerSet = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toSet());

        Function<Set<Integer>, Integer> minFunc = set -> set.stream()
                .mapToInt(n -> n).min().orElse(-1); // <- Намира най-малкото число

        int min = minFunc.apply(integerSet);

        System.out.println(min);

    }

}
