package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction_03_6 {
    public static void main(String[] args) {

        int min = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).min().orElse(-1); // <- Най-малкото число на прочетения ред

        System.out.println(min);

    }

}
