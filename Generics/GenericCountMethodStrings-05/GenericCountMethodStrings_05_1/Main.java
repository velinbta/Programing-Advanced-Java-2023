package GenericCountMethodStrings_05_1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        IntStream.range(0, lines).forEach(line -> {
            // Прочита броя редове и добавя в кутията
            String input = scanner.nextLine();
            box.add(input);
        });

        String valueToCompare = scanner.nextLine();

        // Броя на елементите в кутията, по-големи от дадената стойност
        int countOfGreaterValues = box.getCountOfElementsGraterThanGivenOtherValue(valueToCompare);

        System.out.println(countOfGreaterValues);

    }

}
