package Threeuple_11_1;

// Generic class Threeuple<> holding three objects
public class Threeuple<F, S, T> {

    private F first;
    private S second;
    private T third;

    public Threeuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    public T getThird() {
        return this.third;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", getFirst(), getSecond(), getThird());
    }

}
