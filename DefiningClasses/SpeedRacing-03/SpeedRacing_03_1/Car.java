package SpeedRacing_03_1;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;

    private int distanceTravel;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        setFuelAmount(fuelAmount);
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public boolean canAnExistingCarBeDrivenCertainKm(int km) {
        // Проверява дали колата може да измине дадени километри с наличното й гориво
        return getFuelAmount() - (km * getFuelCostPerKm()) >= 0;
    }

    public void reduceFuelAmountIncreaseDistanceTravel(int km) {
        // Намаля горивото и увеличава изминатите километри на автомобила
        setDistanceTravel(getDistanceTravel() + km);
        double fuelLeft = getFuelAmount() - (km * getFuelCostPerKm());
        setFuelAmount(fuelLeft);
    }

    public String getModel() {
        return this.model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getFuelCostPerKm() {
        return this.fuelCostPerKm;
    }

    public int getDistanceTravel() {
        return this.distanceTravel;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTravel(int distanceTravel) {
        this.distanceTravel = distanceTravel;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                getModel(), getFuelAmount(), getDistanceTravel());
    }

}
