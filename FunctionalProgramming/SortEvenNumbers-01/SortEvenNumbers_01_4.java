package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01_4 {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();

        List<Integer> numbersList = Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbersList.removeIf(n -> n % 2 != 0); // <- Премахвам нечетните

        System.out.println(numbersList.toString().replaceAll("[\\[\\]]", ""));

        numbersList.sort(Comparator.comparingInt(n -> n)); // <- Сортирам в нарастващ ред

        System.out.println(numbersList.toString().replaceAll("[\\[\\]]", ""));

    }

}
