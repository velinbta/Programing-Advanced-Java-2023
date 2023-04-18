package FunctionalProgramming;

import java.util.*;
import java.util.function.IntPredicate;

public class CustomComparator_08_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        IntPredicate even = n -> n % 2 == 0;
        IntPredicate odd = n -> n % 2 != 0;

        List<Integer> resultList = new ArrayList<>();
        // Филтрира първо сортираните четни, след това нечетни
        filterIntArrayByConditionSortAndAddToList(input, even, resultList);
        filterIntArrayByConditionSortAndAddToList(input, odd, resultList);

        resultList.forEach(n -> System.out.print(n + " "));

    }

    private static void filterIntArrayByConditionSortAndAddToList(int[] input, IntPredicate condition,
                                                                  List<Integer> resultList) {

        Arrays.stream(input).filter(condition).sorted().forEach(resultList::add);

    }

}
