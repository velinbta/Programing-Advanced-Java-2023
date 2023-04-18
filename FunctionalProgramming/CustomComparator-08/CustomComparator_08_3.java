package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator_08_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> naturalOrder = Comparator.naturalOrder(); // <- Нарастващ ред
        Comparator<Integer> evenFirst = Comparator.comparing(n -> n % 2 != 0); // <- Първо четните

        Arrays.sort(numArr, naturalOrder);
        Arrays.sort(numArr, evenFirst);

        Arrays.stream(numArr).forEach(n -> System.out.print(n + " "));

    }

}
