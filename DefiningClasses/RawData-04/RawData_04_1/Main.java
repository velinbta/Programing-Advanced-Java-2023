package RawData_04_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            // Акумулирам информацията и добавям в списъка
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure,
                    tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car.carList.add(car);

        }

        String cargoTypeCommand = scanner.nextLine();

        // Филтрирам или "запалимите" или "чупливите"
        Car.carList.stream().filter(car -> car.isFlamable(cargoTypeCommand) || car.isFragile(cargoTypeCommand))
                .forEach(car -> System.out.println(car.getModel()));

    }

}
