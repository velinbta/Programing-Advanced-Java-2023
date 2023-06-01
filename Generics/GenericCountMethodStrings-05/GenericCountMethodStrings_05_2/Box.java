package GenericCountMethodStrings_05_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

// Generic Box<>
public class Box<T> {

    private List<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void add(T element) {
        this.box.add(element);
    }

    public int size() {
        return this.box.size();
    }

    public boolean isEmpty() {
        return this.box.isEmpty();
    }

    public void swap(int firstIndex, int secondIndex) {
        verifyIndices(firstIndex, secondIndex);

        // Разменя индексите в кутията
        Collections.swap(this.box, firstIndex, secondIndex);
    }

    public T removeIndex(int index) {
        indexCheck(index);
        return this.box.remove(index);
    }

    // Статичен метод за сравнение от списък - List<T>
    public static <T extends Comparable<T>> int getCountOfElementsInListGreaterThanGivenValue(List<T> list, T other) {
        return (int) list.stream().filter(e -> e.compareTo(other) > 0).count();
    }

    private void verifyIndices(int firstIndex, int secondIndex) {
        // Проверява индексите в кутията
        if (isEmpty())
            throw new IllegalArgumentException("Box is empty");
        else if (firstIndex < 0)
            throw outOfBoundsException(String.format("Index: %d can't be negative", firstIndex));
        else if (secondIndex < 0)
            throw outOfBoundsException(String.format("Index: %d can't be negative", secondIndex));
        else if (firstIndex >= size())
            throw outOfBoundsException(String.format("Index: %d out of bounds for length %d", firstIndex, size()));
        else if (secondIndex >= size())
            throw outOfBoundsException(String.format("Index: %d out of bounds for length %d", secondIndex, size()));

    }

    private void indexCheck(int index) {
        if (index < 0 || index >= this.box.size())
            throw outOfBoundsException(String.format("%d is out of bounds for length %d", index, size()));
    }

    private IndexOutOfBoundsException outOfBoundsException(String message) {
        throw new IndexOutOfBoundsException(message);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        IntStream.range(0, this.box.size()).forEach(e -> {
            sb.append(String.format("%s: %s", this.box.get(e).getClass().getName(), this.box.get(e)));
            if (e != size() - 1) {
                sb.append(System.lineSeparator());
            }
        }); // Името на класа и всеки един елемент в кутията

        return sb.toString();
    }

}
