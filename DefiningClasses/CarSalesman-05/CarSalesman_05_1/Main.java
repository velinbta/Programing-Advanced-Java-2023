package CarSalesman_05_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engineLines = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();

        // Извличам информацията за колата и типовете двигатели и ги добавям в списъци
        for (int i = 0; i < engineLines; i++) {

            String[] engineData = scanner.nextLine().split("\\s+");
            Engine engine = getEngine(engineData);
            engineList.add(engine);

        }

        int carLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carLines; i++) {

            String[] carData = scanner.nextLine().split("\\s+");
            Car car = getCar(carData);
            carList.add(car);

        }

        engineList.forEach(engine ->
                // Проверявам всеки един модел на двигателя, дали съвпада с двигателя на колите:
                // При съвпадение - добавям информацията в списъка с обекти "Car".
                carList.forEach(car -> {

                    if (car.getEngine().equals(engine.getModel())) {
                        car.setPower(engine.getPower());
                        car.setDisplacement(engine.getDisplacement());
                        car.setEfficiency(engine.getEfficiency());
                    }

                }));

        carList.forEach(System.out::println); // <- Принтирам всяка една кола по шаблон

    }

    private static Engine getEngine(String[] engineData) {
        // Връща нов Engine, в зависимост от размера и типа на данните
        String model = engineData[0];
        int power = Integer.parseInt(engineData[1]);

        switch (engineData.length) {

            case 4:

                Integer displacement = Integer.parseInt(engineData[2]);
                String efficiency = engineData[3];

                return new Engine(model, power, displacement, efficiency);

            case 3:

                return engineData[2].matches("\\d+")
                        ? new Engine(model, power, Integer.parseInt(engineData[2])) // <- displacement
                        : new Engine(model, power, engineData[2]); // <- efficiency

            case 2:

                return new Engine(model, power);

            default:

                throw new IllegalArgumentException("Invalid data");

        }

    }

    private static Car getCar(String[] carData) {
        // Връща нов Car, в зависимост от размера и типа на данните
        String model = carData[0];
        String engine = carData[1];

        switch (carData.length) {

            case 4:

                int weight = Integer.parseInt(carData[2]);
                String color = carData[3];

                return new Car(model, engine, weight, color);

            case 3:

                return carData[2].matches("\\d+")
                        ? new Car(model, engine, Integer.parseInt(carData[2])) // <- weight
                        : new Car(model, engine, carData[2]); // <- color

            case 2:

                return new Car(model, engine);

            default:

                throw new IllegalArgumentException("Invalid data");

        }

    }

}
