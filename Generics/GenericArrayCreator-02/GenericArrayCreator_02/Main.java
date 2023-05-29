package GenericArrayCreator_02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);
        Double[] doubles = ArrayCreator.create(Double.class, 5, 13.00);
        Scanner[] scanners = ArrayCreator.create(Scanner.class, 3, new Scanner(System.in));

        System.out.println(Arrays.stream(strings).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(integers).map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(doubles).map(String::valueOf)
                .collect(Collectors.joining(", ")).replaceAll(".0", ".00"));
        System.out.printf("Scanner[] contains %d scanners\n", scanners.length);

    }

}
