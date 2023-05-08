package CatLady_09_1;

public class StreetExtraordinaire extends Cat {
    private double decibels;

    public StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.decibels = decibels;
    }

    public double getDecibels(){
        return this.decibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", getName(), getDecibels());
    }

}
