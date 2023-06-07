package Tuple_10_1;

// Generic class Tuple<> holding two objects
public class Tuple<F, S> {

    private F first;
    private S second;

    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", getFirst(), getSecond());
    }

}
