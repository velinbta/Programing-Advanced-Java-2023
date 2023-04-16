package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07_2 {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getSmallestIntegerInList = list ->
                list.stream().mapToInt(n -> n).min().orElse(-1); // <- Намира най-малкото число в списък

        int smallestInt = getSmallestIntegerInList.apply(intList);

        int indexOfRightMostSmallestInt = intList.lastIndexOf(smallestInt); // <- Последния индекс(най-десния)

        System.out.println(indexOfRightMostSmallestInt);

    }

}
