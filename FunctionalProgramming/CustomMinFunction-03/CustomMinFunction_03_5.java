package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class CustomMinFunction_03_5 {
    public static void main(String[] args) {

        String numbersAsString = new Scanner(System.in).nextLine();

        // Намирам най-малкото число от прочетения ред и го връщам като String
        UnaryOperator<String> minStringOperator = s -> String.valueOf(Arrays.stream(s.split("\\s+"))
                .mapToInt(Integer::parseInt).min().orElse(-1));

        String min = minStringOperator.apply(numbersAsString);

        System.out.println(min);

    }

}
