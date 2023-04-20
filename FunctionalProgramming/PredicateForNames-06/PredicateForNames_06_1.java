package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLength = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        // По-малка или равна дължина от даденото число
        Predicate<String> lengthEqualOrLess = n -> n.length() <= maxLength;

        Arrays.stream(names).filter(lengthEqualOrLess).forEach(System.out::println);

    }

}
