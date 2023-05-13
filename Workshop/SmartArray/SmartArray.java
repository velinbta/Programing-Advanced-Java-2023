package SmartArray;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;

// Custom implementation of Integer SmartArray class
public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity = INITIAL_CAPACITY;
    private int size;
    private int[] array;

    public SmartArray() {
        this.array = new int[INITIAL_CAPACITY];
    }

    public void add(int element) { // <- Добавя накрая
        ensureCapacity();
        this.array[this.size++] = element;
    }

    public void add(int index, int element) {
        // Добавя на определен индекс - елемент
        // Премества останалите елементи надясно
        rangeCheckForAdd(index);
        ensureCapacity();

        for (int i = size(); i > index; i--) {
            this.array[i] = this.array[i - 1];
        }

        this.array[index] = element;
        this.size++;
    }

    public int get(int index) {
        ensureBounds(index);
        return this.array[index];
    }

    public int remove(int index) {
        // Премахва и/или връща индекс
        ensureBounds(index);
        int removedElement = this.array[index];

        for (int i = index; i < size(); i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[size() - 1] = 0;
        this.size--;

        ensureCapacity();
        return removedElement;
    }

    public boolean contains(int element) {
        return Arrays.stream(this.array).anyMatch(e -> e == element);
    }

    public void forEach(Consumer<Integer> consumer) {
        IntStream.range(0, size()).forEach(n -> consumer.accept(this.array[n]));
    }

    public int size() {
        return this.size;
    }

    private void ensureCapacity() {

        if (size() >= this.capacity) {
            this.capacity = size() * 2;
            grow();

        } else if (size() != 0 && this.capacity / 4 > size()) {
            this.capacity /= 4;
            shrink();
        }

    }

    private void grow() {
        // Увеличава двойно размера си
        int[] newArray = new int[this.capacity];

        for (int i = 0; i < size(); i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    private void shrink() {
        // Намалява 4 пъти, ако се премахват достатъчно елементи
        int[] newArray = new int[this.capacity];

        for (int i = 0; i < size(); i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    private void ensureBounds(int index) { // <- Проверява граници
        if (index < 0 || index >= size())
            ThrowOutOfBoundsException(index);
    }

    private void rangeCheckForAdd(int index) { // <- Проверява граници при добавяне
        if (index < 0 || index > size())
            ThrowOutOfBoundsException(index);
    }

    private void ThrowOutOfBoundsException(int index) {
        throw new IndexOutOfBoundsException(String.format("Index %s out of bounds for length %d", index, size()));
    }

}
