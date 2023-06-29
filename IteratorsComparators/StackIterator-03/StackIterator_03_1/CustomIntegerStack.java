package StackIterator_03_1;

import java.util.*;

// Iterable CustomIntegerStack
public class CustomIntegerStack implements Iterable<Integer> {

    private Deque<Integer> stack;

    public CustomIntegerStack() {
        this.stack = new ArrayDeque<>();
    }

    public CustomIntegerStack(Deque<Integer> otherStack) {
        this.stack = new ArrayDeque<>(otherStack);
    }

    private class CustomIntegerStackIterator implements Iterator<Integer> { // <- Iterator

        private final CustomIntegerStack innerStack = new CustomIntegerStack(stack);

        @Override
        public boolean hasNext() {
            return innerStack.peek() != null;
        }

        @Override
        public Integer next() {
            return innerStack.pop();
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIntegerStackIterator();
    }

    public void push(Integer... integers) {
        // Приема Integer varargs и ги добавя в обратен ред
        Arrays.stream(integers).forEach(this.stack::push);
    }

    public Integer pop() {

        try {
            return this.stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("No elements");
        }

        return null;
    }

    public int size() {
        return this.stack.size();
    }

    public Integer peek() {
        return this.stack.peek();
    }

}
