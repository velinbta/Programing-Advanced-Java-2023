package RawData_04_2;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getType() {
        return this.type;
    }

}
