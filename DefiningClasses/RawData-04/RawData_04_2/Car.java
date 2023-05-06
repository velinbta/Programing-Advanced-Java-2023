package RawData_04_2;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tyre> tyres;

    public Car(String model) {
        this.model = model;
        this.tyres = new ArrayList<>();
    }

    public boolean containsAtLeastOneTyreBelowOrEqualToOne() {
        return tyres.stream().anyMatch(tyre -> tyre.getPressure() <= 1);
    }

    public boolean hasEngineAbove250HorsePower() {
        return getEngine().getPower() > 250;
    }

    public void setEngine(int speed, int power) {
        this.engine = new Engine(speed, power);
    }

    public void setCargo(int weight, String type) {
        this.cargo = new Cargo(weight, type);
    }

    public String getModel() {
        return this.model;
    }

    public void addTyre(double pressure, int age) {
        this.tyres.add(new Tyre(pressure, age));
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    @Override
    public String toString() {
        return getModel();
    }

}
