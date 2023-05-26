package DoublyLinkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.IntStream;

// Custom implementation of Integer DoublyLinkedList class
public class IntegerDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        // Всеки един Node, знае за следващия и предходния
        private int element;
        private Node next;
        private Node previous;

        private Node(int element) {
            this.element = element;
        }
    }

    public void addFirst(int element) {
        // Добавя в началото
        Node newNode = new Node(element);

        if (isEmpty())
            this.head = this.tail = newNode;
        else {

            Node currentNode = this.head;
            currentNode.previous = newNode;

            this.head = newNode;
            this.head.next = currentNode;

        }
        this.size++;
    }

    public void addLast(int element) {
        // Добавя накрая
        Node newNode = new Node(element);

        if (isEmpty())
            addFirst(element);
        else {

            Node currentNode = this.tail;
            currentNode.next = newNode;

            this.tail = newNode;
            this.tail.previous = currentNode;

            this.size++;
        }
    }

    public int get(int index) {
        // Връща по индекс
        checkIndex(index);

        int counter = 0;

        Node currentNode = this.head;

        while (currentNode != null) {

            if (counter + 10 < index && counter + 10 < getSize()) {
                // Прескача 11 индекса напред
                counter += 11;
                currentNode = currentNode.next.next.next.next.next.next.next.next.next.next.next;

            } else if (counter == index)
                // Връща елемента на посочения индекс
                return currentNode.element;
            else
                counter++;
            currentNode = currentNode.next;

        }

        throw indexException(index);
    }

    public int getFirst() {
        if (isEmpty())
            throw noSuchElementException();
        else
            return this.head.element;
    }

    public int getLast() {
        if (isEmpty())
            throw noSuchElementException();
        else
            return this.tail.element;
    }

    public int removeFirst() {

        if (isEmpty())
            throw noSuchElementException();
        else {
            int removedHead = this.head.element;

            if (this.head.next == null) { // <- Ако няма следващ
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next; // <- Слагам следващия за първи
                this.head.previous = null;
            }
            this.size--;

            return removedHead;
        }
    }

    public int removeLast() {

        if (isEmpty())
            throw noSuchElementException();
        else {
            int removedTail = this.tail.element;

            if (this.tail.previous == null) { // <- Ако няма предходен
                this.tail = null;
                this.head = null;
            } else {
                this.tail = this.tail.previous; // <- Слагам предходния за последен
                this.tail.next = null;
            }
            this.size--;

            return removedTail;
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        // Обхожда от главата до опашката
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        // Връща листа, като int[]
        int[] array = new int[getSize()];
        final Node[] currentNode = {this.head};

        IntStream.range(0, getSize()).forEach(n -> {
            array[n] = currentNode[0].element;
            currentNode[0] = currentNode[0].next;
        });

        return array;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private void checkIndex(int index) {
        // Валидира индекс
        if (index < 0 || index >= getSize())
            throw indexException(index);
    }

    private IndexOutOfBoundsException indexException(int index) {
        throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds for length %d",
                index, getSize()));
    }

    private NoSuchElementException noSuchElementException() {
        throw new NoSuchElementException("IntegerDoublyLinkedList is empty!");
    }

}
