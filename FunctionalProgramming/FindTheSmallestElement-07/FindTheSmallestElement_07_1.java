package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07_1 {
    public static void main(String[] args) {

        int[] intArr = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getSmallestElement = arr ->
                Arrays.stream(arr).min().orElse(-1); // <- Намира най-малкото число в масива

        // Намира най-десния елемент на дадено число
        BiFunction<int[], Integer, Integer> getRightMostIndexOfElement = (arr, element) ->
                Arrays.stream(arr).boxed().collect(Collectors.toList()).lastIndexOf(element);

        int smallestElement = getSmallestElement.apply(intArr);
        int rightMostSmallestElement = getRightMostIndexOfElement.apply(intArr, smallestElement);

        System.out.println(rightMostSmallestElement);

    }

}
