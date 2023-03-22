package SetsMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Оригиналния списък остава запазазен
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(n -> Integer.parseInt(n)).collect(Collectors.toList());

        // Записвам масив от най-много 3 най-големи числа в поредицата
        int[] largest3NumbersArr = getAtMostThreeLargestNumbers(numbersList);

        Arrays.stream(largest3NumbersArr).forEach(n -> System.out.print(n + " "));

    }

    private static int[] getAtMostThreeLargestNumbers(List<Integer> numbersList) {
        // Намира най-много 3 най-големи числа в поредицата, като запазва оригиналния списък
        List<Integer> copyList = new ArrayList<>(numbersList);

        Integer[] tempArr = new Integer[3];

        int rotation = 0;

        while (rotation < 3 && !copyList.isEmpty()) {
            int max = Integer.MIN_VALUE;

            for (Integer current : copyList) { // <- Обикаля всички и задава най-голямата стойност

                if (current > max)
                    max = current;

            }
            tempArr[rotation] = max;
            copyList.remove(Integer.valueOf(max)); // <- Махам най-голямата стойност

            rotation++;
        }

        return getLessNumbersIfListHasLessElements(tempArr); // <- Връща крайния масив

    }

    private static int[] getLessNumbersIfListHasLessElements(Integer[] tempArr) {
        // Връща масив от най-малките стойности, като игнорира празните стойности
        int countNull = 0;
        for (Integer current : tempArr) {

            if (current == null) // <- Брой празните стойности, ако има такива
                countNull++;

        }

        int[] largestNumbers = new int[tempArr.length - countNull]; // <- Нов масив, от вече крайните елементи

        for (int i = 0; i < tempArr.length; i++) {

            if (tempArr[i] != null)
                largestNumbers[i] = tempArr[i];
            else
                break;

        }

        return largestNumbers;
    }

}
