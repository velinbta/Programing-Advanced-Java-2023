package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class CustomMinFunction_03_5 {
    public static void main(String[] args) {

        // Намира най-малкото число от прочетен String, и го принтира
        Consumer<String> readLineOfStringFindMinAndPrint = line -> System.out.println
                (Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).min().orElse(-1));

        readLineOfStringFindMinAndPrint.accept(new Scanner(System.in).nextLine());

    }

}
