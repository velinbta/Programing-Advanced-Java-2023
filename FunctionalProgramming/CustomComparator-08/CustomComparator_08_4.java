package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator_08_4 {
    public static void main(String[] args) {

        Integer[] numArr = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        // Четните във възходящ ред и нечетните след това, като и те са във възходящ ред
        Comparator<Integer> evenFirstOddSecondNaturalOrder = ((first, second) -> {

            if (first % 2 == 0 && second % 2 != 0)
                return -1;
            else if (first % 2 != 0 && second % 2 == 0)
                return 1;

            return first.compareTo(second);

        });

        Arrays.sort(numArr, evenFirstOddSecondNaturalOrder);
        Arrays.stream(numArr).forEach(n -> System.out.print(n + " "));

    }

}
