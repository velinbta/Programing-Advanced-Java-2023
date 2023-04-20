package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03_4 {
    public static void main(String[] args) {

        String numbersAsString = new Scanner(System.in).nextLine();

        // Превръщам в колекция и намирам най-малкото число
        Function<String, Integer> minFunc = s -> Collections.min(Arrays.stream(s.split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList()));

        int min = minFunc.apply(numbersAsString);

        System.out.println(min);

    }

}
