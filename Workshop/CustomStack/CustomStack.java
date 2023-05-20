package CustomStack;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Custom implementation of integer Stack, using int[]
public class CustomStack {
    private final int INITIAL_CAPACITY = 4;

    private int capacity = INITIAL_CAPACITY;
    private int position = this.capacity - 1;
    private int size;
    private int[] stack;

    public CustomStack() {
        this.stack = new int[INITIAL_CAPACITY];
    }

    public void push(int element) {
        ensureCapacity();
        this.stack[this.position--] = element;
        this.size++;
    }

    public int pop() {
        ensureBounds();
        ensureCapacity();

        int lastElement = this.stack[this.position + 1];
        this.stack[this.position + 1] = 0;
        this.position++;
        this.size--;

        return lastElement;
    }

    public int peek() {
        ensureBounds();
        return this.stack[this.position + 1];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        this.stack = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
        this.position = this.capacity - 1;
        this.size = 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        IntStream.range(this.position + 1, this.stack.length).forEach(n -> consumer.accept(this.stack[n]));
    }

    @Override
    public String toString() {
        // Всеки int на нов ред
        return IntStream.range(this.position + 1, this.stack.length)
                .mapToObj(n -> String.valueOf(this.stack[n])).
                collect(Collectors.joining(System.lineSeparator()));
    }

    private void ensureCapacity() {
        if (size() >= this.capacity)
            grow();
        else if (size() > this.INITIAL_CAPACITY && this.capacity / 4 == size())
            // Ако капацитетът му разделен на 4 е равен на размера се смалява на половина
            shrink();
    }

    private void grow() {
        // Пораства в двоен размер
        this.capacity *= 2;
        int oldStackPosition = size() - 1;
        int[] newStack = new int[this.capacity];

        for (int i = this.capacity - 1; i >= size(); i--)
            newStack[i] = this.stack[oldStackPosition--];

        this.position = Math.abs(this.position + size());
        this.stack = newStack;
    }

    private void shrink() {
        // Смалява се двойно, единствено ако капацитетът разделен на 4 е равен на размера
        int oldStackPosition = this.capacity - 1;

        this.capacity /= 2;
        this.position = this.capacity - 1;

        int[] newStack = new int[this.capacity];

        for (int i = this.capacity - 1; i >= size(); i--, this.position--) {
            newStack[i] = this.stack[oldStackPosition--];
        }

        this.stack = newStack;
    }

    private void ensureBounds() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty!");
    }

}
