package GenericScale_03;

public class Scale<T extends Comparable<T>> {

    private final T left;
    private final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        // Връща по-голямото от двете
        if (this.left.compareTo(this.right) < 0)
            return this.right;
        else if (this.right.compareTo(this.left) < 0)
            return this.left;

        return null;
    }

}
