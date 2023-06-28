package Collection_02_1;

import java.util.*;
import java.util.function.Consumer;

// Iterable generic class ListyIterator<>
public class ListyIterator<T> implements Iterable<T> {

    private final List<T> collection;
    private int internalIndex = 0;

    @SafeVarargs
    public ListyIterator(T... elements) {
        this.collection = new ArrayList<>(Arrays.asList(elements));
    }

    public boolean move() {
        // Премества индекса, ако има следващ елемент
        if (this.hasNext()) {
            this.internalIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.internalIndex < this.collection.size() - 1;
    }

    public void printCurrentIndex() {
        // Принтира елемента на текущия индекс, ако не е празна колекцията
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(this.collection.get(this.internalIndex));
    }

    public void printAll() {
        this.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return this.iteratorIndex < collection.size();
            }

            @Override
            public T next() {
                return collection.get(iteratorIndex++);
            }

        };

    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        for (T element : collection)
            consumer.accept(element);
    }

}
