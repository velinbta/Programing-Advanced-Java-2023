package SetsMaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Прочитам сортиран списък в нарастващ ред
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(n -> Integer.parseInt(n)).sorted().collect(Collectors.toList());

        Collections.reverse(numbersList); // <- Обръщам реда му

        // Правя нов списък с трите най-големи числа
        List<Integer> largestThreeNumbersList = numbersList.stream().limit(3).collect(Collectors.toList());

        largestThreeNumbersList.forEach(n -> System.out.print(n + " "));

    }

}
