package CatLady_09_1;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize(){
        return this.earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", getName(), getEarSize());
    }

}
