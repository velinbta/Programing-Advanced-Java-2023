package JarOfT_01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Jar<T> {

    private Deque<T> jar;

    public Jar() {
        this.jar = new ArrayDeque<>();
    }

    public void add(T element) {
        this.jar.push(element);
    }

    public T remove() {
        if (isEmpty()) throw noSuchElementException();

        return this.jar.pop();
    }

    public int size() {
        return this.jar.size();
    }

    public boolean isEmpty() {
        return this.jar.isEmpty();
    }

    private NoSuchElementException noSuchElementException() {
        throw new NoSuchElementException("Jar is empty!");
    }

}
