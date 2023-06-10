package Library_02_1;

import java.util.Iterator;

// Iterable Library
public class Library implements Iterable<Book> {

    private Book[] books;
    private Iterator<Book> iterator;

    public Library(Book... books) {
        this.books = books;
    }

    private class LibIterator implements Iterator<Book> { // <- Iterator

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < books.length;
        }

        @Override
        public Book next() {
            return books[counter++];
        }

    }

    @Override
    public Iterator<Book> iterator() {
        return this.iterator = new LibIterator();
    }

}
