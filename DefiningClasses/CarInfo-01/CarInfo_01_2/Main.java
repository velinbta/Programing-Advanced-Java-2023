package CarInfo_01_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = readTerminalData(scanner);

        List<Car> carsList = new ArrayList<>();

        // От прочетения масив ми връща нова кола, която добавям в списък от коли
        Arrays.stream(data).map(line -> {
            String[] info = line.split("\\s+");
            String brand = info[0];
            String model = info[1];
            int horsePower = Integer.parseInt(info[2]);
            return new Car(brand, model, horsePower);
        }).forEach(carsList::add);

        carsList.forEach(System.out::println);

    }

    private static String[] readTerminalData(Scanner scanner) {
        // Прочита дадените редове от конзолата и ги добавя в масив
        int lines = Integer.parseInt(scanner.nextLine());
        String[] data = new String[lines];

        IntStream.range(0, lines).forEach(line -> data[line] = scanner.nextLine());

        return data;
    }

}
