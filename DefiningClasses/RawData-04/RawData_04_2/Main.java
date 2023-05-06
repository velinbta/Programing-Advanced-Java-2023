package RawData_04_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carLines = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carLines; i++) {
            // Акумулирам информацията от масива и добавям в списъка с коли
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];

            Car car = new Car(model);
            cars.add(car);

            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            car.setEngine(engineSpeed, enginePower);
            car.setCargo(cargoWeight, cargoType);
            addTyres(data, car); // <- Добавя гумите

        }

        String condition = scanner.nextLine();

        switch (condition) { // <- Търси и филтрира според условието

            case "fragile":

                cars.stream().filter(car -> car.getCargo().getType().equals(condition))
                        .filter(Car::containsAtLeastOneTyreBelowOrEqualToOne)
                        .forEach(System.out::println);

                break;

            case "flamable":

                cars.stream().filter(car -> car.getCargo().getType().equals(condition))
                        .filter(Car::hasEngineAbove250HorsePower)
                        .forEach(System.out::println);

                break;

            default:
                throw new IllegalArgumentException("Unknown condition " + condition);

        }

    }

    private static void addTyres(String[] data, Car car) {
        // Добавя гумите от масива - на съответния автомобил
        for (int j = 5; j < data.length; j += 2) {
            double pressure = Double.parseDouble(data[j]);
            int age = Integer.parseInt(data[j + 1]);
            car.addTyre(pressure, age);
        }

    }

}
