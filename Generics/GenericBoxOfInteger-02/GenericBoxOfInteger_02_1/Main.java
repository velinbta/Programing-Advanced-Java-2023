package GenericBoxOfInteger_02_1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        // Прочитам броя редове и добавям в кутията
        IntStream.range(0, lines).forEach(line -> {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        });

        System.out.println(box);

    }

}
