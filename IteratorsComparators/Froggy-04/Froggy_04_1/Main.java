package Froggy_04_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Прочита числата и добавя в "lake"
        Integer[] values = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Lake lake = new Lake(values);

        // Първо четните индекси, после нечетните, разделени с запетая
        String output = lake.getEvenIndicesFirstOddSecond();

        System.out.println(output);

    }

}
