package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLength = Integer.parseInt(scanner.nextLine());

        // Принтира само думите с по-малка или равна дължина
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(w -> w.length() <= maxLength).forEach(System.out::println);

    }

}
