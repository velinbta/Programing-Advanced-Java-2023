package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude_05_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbersList); // <- Обръщам числата

        int divisibleOption = Integer.parseInt(scanner.nextLine());

        numbersList.removeIf(n -> n % divisibleOption == 0); // <- Премахвам от списъка ако се делят на даденото число

        numbersList.forEach(n -> System.out.print(n + " "));

    }

}
