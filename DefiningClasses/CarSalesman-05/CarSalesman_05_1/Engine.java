package CarSalesman_05_1;

public class Engine {
    private String model;
    private Integer power;

    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power, Integer displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, Integer power, Integer displacement) {
        this(model, power, displacement, null);
    }

    public Engine(String model, Integer power, String efficiency) {
        this(model, power, null, efficiency);
    }

    public Engine(String model, Integer power) {
        this(model, power, null, null);
    }

    public String getModel() {
        return this.model;
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

}
