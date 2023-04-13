package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {

        String[] names = new Scanner(System.in).nextLine().split("\\s+");

        // Добавя "Sir " пред всяко от имената на масива и принтира
        Consumer<String[]> appendSirAndPrint = arr -> Arrays.stream(arr).map(w ->
                        w = new StringBuilder(w).reverse().append(" riS").reverse().toString())
                .forEach(System.out::println);

        appendSirAndPrint.accept(names);

    }

}
