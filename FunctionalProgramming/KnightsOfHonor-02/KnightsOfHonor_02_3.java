package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class KnightsOfHonor_02_3 {
    public static void main(String[] args) {

        UnaryOperator<String> addSirInFront = name -> String.format("Sir %s", name);

        String[] names = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(addSirInFront).toArray(String[]::new); // <- Добавям Sir, пред всяко от имената

        Consumer<String[]> printer = arr -> Arrays.stream(arr).forEach(System.out::println);
        printer.accept(names);

    }

}
