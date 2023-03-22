package SetsMaps;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Прочитам сортиран списък в нарастващ ред
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(n -> Integer.parseInt(n)).sorted().collect(Collectors.toList());

        if (numbersList.size() < 3) { // <- Принтирам целия списък, ако размера му е по-малък от 3

            for (int i = numbersList.size() - 1; i >= 0; i--) {

                System.out.print(numbersList.get(i) + " ");
            }

        } else { // <- Принтирам последните три елемента - те са най-големите

            for (int i = numbersList.size() - 1; i >= numbersList.size() - 3; i--) {

                System.out.print(numbersList.get(i) + " ");

            }

        }

    }

}
