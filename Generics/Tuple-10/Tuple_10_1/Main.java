package Tuple_10_1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Три Generic Tuple<>, съдържащи различни обекти
        String[] data = readArray(scanner);
        String name = String.format("%s %s", data[0], data[1]);
        String address = data[2];

        // First
        Tuple<String, String> nameAddress = new Tuple<>(name, address);

        data = readArray(scanner);
        name = data[0];
        int litersBeer = Integer.parseInt(data[1]);

        // Second
        Tuple<String, Integer> nameLitersBeer = new Tuple<>(name, litersBeer);

        data = readArray(scanner);
        int parseInt = Integer.parseInt(data[0]);
        double parseDouble = Double.parseDouble(data[1]);

        // Third
        Tuple<Integer, Double> integerDouble = new Tuple<>(parseInt, parseDouble);

        String output = getOutput(nameAddress, nameLitersBeer, integerDouble);
        System.out.println(output);

    }

    public static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String getOutput(Tuple... tuples) {
        // Форматира изходните данни
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, tuples.length).forEach(index -> {
            sb.append(tuples[index]);
            if (index != tuples.length - 1) {
                sb.append(System.lineSeparator());
            }
        });

        return sb.toString();
    }

}
