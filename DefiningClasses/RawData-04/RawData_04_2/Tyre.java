package RawData_04_2;

public class Tyre {
    private double pressure;
    private int age;

    public Tyre(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public double getPressure() {
        return this.pressure;
    }

}
