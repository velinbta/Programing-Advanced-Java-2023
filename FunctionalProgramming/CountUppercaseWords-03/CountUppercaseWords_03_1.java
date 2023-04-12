package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords_03_1 {
    public static void main(String[] args) {

        String line = new Scanner(System.in).nextLine();
        Predicate<String> isUpperCase = w -> Character.isUpperCase(w.charAt(0));

        String[] upperCaseWords = Arrays.stream(line.split("\\s+")).filter(isUpperCase)
                .toArray(String[]::new); // <- Само думите с главни букви

        System.out.println(upperCaseWords.length);
        System.out.println(String.join(System.lineSeparator(), upperCaseWords));

    }

}
