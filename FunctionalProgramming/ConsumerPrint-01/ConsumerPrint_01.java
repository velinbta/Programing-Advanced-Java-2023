package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {

        String[] words = new Scanner(System.in).nextLine().split("\\s+");

        Consumer<String[]> printer = w -> Arrays.stream(w).forEach(System.out::println);

        printer.accept(words);

    }

}
