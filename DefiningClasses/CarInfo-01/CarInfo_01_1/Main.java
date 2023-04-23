package CarInfo_01_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carsList = new ArrayList<>();

        int lines = Integer.parseInt(scanner.nextLine());

        IntStream.range(0, lines).forEach(line -> {
            String[] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);

            // Създавам кола с прочетените параметри
            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            // Добавям всички автомобили в списък
            carsList.add(car);
        });

        carsList.forEach(car -> System.out.println(car.carInfo()));

    }

}
