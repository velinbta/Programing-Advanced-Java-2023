package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getSmallestElement = list ->
                list.stream().mapToInt(n -> n).min().orElse(-1); // <- Намира най-малкото число в списък

        int smallestIntegerInList = getSmallestElement.apply(integerList);

        int indexOfRightMostSmallestInteger = smallestIntegerInList != -1
                ? integerList.lastIndexOf(smallestIntegerInList) // <- Последния индекс(най-десния)
                : -1;

        System.out.println(indexOfRightMostSmallestInteger);

    }

}
