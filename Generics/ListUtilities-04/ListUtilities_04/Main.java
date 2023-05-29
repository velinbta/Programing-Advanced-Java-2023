package ListUtilities_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 18, 2, -1, -100));
        int minInteger = ListUtils.getMin(integerList); // -100
        int maxInteger = ListUtils.getMax(integerList); // 18
        System.out.printf("Min integer in List: \"%s\" is %s.\n", integerList.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")), minInteger);
        System.out.printf("Max integer in List: \"%s\" is %s.\n", integerList.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")), maxInteger);

        List<String> stringList = new ArrayList<>(Arrays.asList("a", "b", "c", "w", "z"));
        String minString = ListUtils.getMin(stringList); // "a"
        String maxString = ListUtils.getMax(stringList); // "z"
        System.out.printf("Min string in List: \"%s\" is %s.\n", stringList.stream()
                .collect(Collectors.joining(", ")), minString);
        System.out.printf("Max string in List: \"%s\" is %s.\n", stringList.stream()
                .collect(Collectors.joining(", ")), maxString);

    }

}
