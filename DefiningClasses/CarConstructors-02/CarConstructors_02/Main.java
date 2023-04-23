package CarConstructors_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        IntStream.range(0, lines).forEach(line -> {
            // Прочитам информацията и добавям колите в списък
            String[] data = scanner.nextLine().split("\\s+");

            Car car = data.length == 1
                    ? new Car(data[0]) // <- Конструктор с 1 параметър
                    : new Car(data[0], data[1], Integer.parseInt(data[2])); // <- Конструкторът с 3 параметъра

            carList.add(car);

        });

        carList.forEach(System.out::println);

    }

}
