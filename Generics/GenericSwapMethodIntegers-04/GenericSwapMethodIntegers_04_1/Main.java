package GenericSwapMethodIntegers_04_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        IntStream.range(0, lines).forEach(line -> {
            // Прочита броя редове и добавя в кутията
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        });

        int[] indices = readArray(scanner);
        int firstIndex = indices[0];
        int secondIndex = indices[1];

        box.swap(firstIndex, secondIndex); // <- Разменям индексите

        System.out.println(box);

    }

    private static int[] readArray(Scanner scanner) {
        // Прочита масив от терминала
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

}
