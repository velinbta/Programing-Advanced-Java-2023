package RawData_04_1;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;

    private double tire1Pressure;
    private int tire1Age;
    private double tire2Pressure;
    private int tire2Age;
    private double tire3Pressure;
    private int tire3Age;
    private double tire4Pressure;
    private int tire4Age;

    public static List<Car> carList = new ArrayList<>();

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {

        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;

    }

    public String getModel() {
        return this.model;
    }

    public String getCargoType() {
        return this.cargoType;
    }

    public int getEnginePower() {
        return this.enginePower;
    }

    // Над 250 конски сили
    public boolean isFlamable(String cargoTypeFlamable) {
        return getCargoType().equals(cargoTypeFlamable) && getEnginePower() > 250;
    }

    // Дори и една от гумите да е с налягане по-ниско от 1
    public boolean isFragile(String cargoTypeFragile) {
        return getCargoType().equals(cargoTypeFragile) && (this.tire1Pressure < 1 || this.tire2Pressure < 1 ||
                this.tire3Pressure < 1 || this.tire4Pressure < 1);
    }

}
