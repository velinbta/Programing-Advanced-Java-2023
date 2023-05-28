package GenericArrayCreator_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);
        Double[] doubles = ArrayCreator.create(Double.class, 5, 13.00);
        Scanner[] scanners = ArrayCreator.create(Scanner.class, 3, new Scanner(System.in));

        Arrays.stream(doubles).forEach(d -> System.out.printf("%.2f ", d));

    }

}
