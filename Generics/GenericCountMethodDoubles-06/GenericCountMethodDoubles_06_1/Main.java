package GenericCountMethodDoubles_06_1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();

        IntStream.range(0, lines).forEach(line -> {
            // Прочита броя редове и добавя в кутията
            double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        });

        double valueToCompare = Double.parseDouble(scanner.nextLine());

        // Броя на елементите в кутията, по-големи от дадената стойност
        int countOfGreaterValues = box.getCountOfElementsGraterThanGivenOtherValue(valueToCompare);

        System.out.println(countOfGreaterValues);

    }

}
