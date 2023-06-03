package CustomListSorter_08_1;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

// Comparable Generic CustomList<>
public class CustomList<T extends Comparable<T>> {

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public T get(int index) {
        indexCheck(index);
        return this.list.get(index);
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        // Премахва по индекс
        indexCheck(index);
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        // Разменя местата на два индекса
        indexCheck(firstIndex);
        indexCheck(secondIndex);
        Collections.swap(this.list, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        // Връща най-голямото
        return this.list.stream().max(Comparator.naturalOrder()).
                orElseThrow(noSuchElementException());
    }

    public T getMin() {
        // Връща най-малкото
        return this.list.stream().min(Comparator.naturalOrder()).
                orElseThrow(noSuchElementException());
    }

    public int size() {
        return this.list.size();
    }

    private void indexCheck(int index) {
        // Проверява дали индекса е в границите на списъка
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(String.format("%s is out of bounds for length %d", index, size()));
    }

    private Supplier<NoSuchElementException> noSuchElementException() {
        return () -> new NoSuchElementException("CustomList is empty!");
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        IntStream.range(0, size()).forEach(line -> {
            sb.append(this.list.get(line));
            if (line != size() - 1)
                sb.append(System.lineSeparator());
        });

        return sb.toString();

    }

}
