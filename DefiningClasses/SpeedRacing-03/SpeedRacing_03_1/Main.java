package SpeedRacing_03_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = readAndAddCars(scanner);

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] data = command.split("\\s+");
            String carModel = data[1];
            int amountOfKm = Integer.parseInt(data[2]);

            Car carNeeded = carList.stream().filter(car -> car.getModel().equals(carModel))
                    .findFirst().orElse(null); // <- Колата от списъка, която ще обработя

            // Ако съм я намерил и може да мине дадените километри, намалям й горивото и увеличивам км
            if (carNeeded != null && carNeeded.canAnExistingCarBeDrivenCertainKm(amountOfKm)) {

                carNeeded.reduceFuelAmountIncreaseDistanceTravel(amountOfKm);

            } else { // <- Ако не може да мине дадените километри

                System.out.println("Insufficient fuel for the drive");

            }

            command = scanner.nextLine();
        }

        carList.forEach(System.out::println);

    }

    private static List<Car> readAndAddCars(Scanner scanner) {
        // Прочита данните и добавя в списък от коли
        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        IntStream.range(0, lines).forEach(line -> {

            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelCostPerKm = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);

            carList.add(car);

        });

        return carList;
    }

}
