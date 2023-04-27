package CarSalesman_05_1;

public class Car {
    private String model;
    private String engine;

    private Integer power;
    private Integer displacement;
    private String efficiency;

    private Integer weight;
    private String color;

    public Car(String model, String engine, Integer weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, String engine, Integer weight) {
        this(model, engine, weight, null);
    }

    public Car(String model, String engine, String color) {
        this(model, engine, null, color);
    }

    public Car(String model, String engine) {
        this(model, engine, null, null);
    }

    public String getModel() {
        return this.model;
    }

    public String getEngine() {
        return this.engine;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    public Integer getPower() {
        return this.power;
    }

    public Integer getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        // Всеки null бива заместван с n/a
        return String.format("%s:\n%s:\nPower: %d\nDisplacement: %d\nEfficiency: %s\nWeight: %d\nColor: %s",
                        getModel(), getEngine(), getPower(), getDisplacement(), getEfficiency(), getWeight(), getColor())
                .replaceAll("null", "n/a");
    }

}
