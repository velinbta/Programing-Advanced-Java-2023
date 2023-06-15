package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

// class Parking
public class Parking {

    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (verifyCapacity()) {
            this.data.add(car);
            this.capacity--;
        }
    }

    public boolean remove(String manufacturer, String model) {

        if (this.data.stream().anyMatch(car -> car.getManufacturer().equals(manufacturer) &&
                car.getModel().equals(model))) {
            this.capacity++;
        }

        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer))
                .filter(car -> car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {

        StringBuilder statistic = new StringBuilder();

        statistic.append(String.format("The cars are parked in %s:", getType()));
        statistic.append(System.lineSeparator());

        IntStream.range(0, this.data.size()).forEach(index -> {
            statistic.append(this.data.get(index));
            if (index != this.data.size() - 1) {
                statistic.append(System.lineSeparator());
            }
        });

        return statistic.toString();
    }


    public String getType() {
        return this.type;
    }

    private boolean isEmpty() {
        return this.data.isEmpty();
    }

    private boolean verifyCapacity() {
        return this.capacity > 0;
    }

}
