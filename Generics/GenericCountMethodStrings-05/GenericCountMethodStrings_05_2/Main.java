package GenericCountMethodStrings_05_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<String> list = new ArrayList<>();

        IntStream.range(0, lines).forEach(line -> {
            // Добавя в списъка
            String input = scanner.nextLine();
            list.add(input);
        });

        String valueToCompare = scanner.nextLine();

        // Кутията връща броя на всички по-големи стойности от дадената
        int greaterElements = Box.getCountOfElementsInListGreaterThanGivenValue(list, valueToCompare);

        System.out.println(greaterElements);

    }

}
