package Library_02_2;

import java.util.Iterator;

// Iterable Library
public class Library<Book> implements Iterable<Book> {

    private Book[] books;

    @SafeVarargs
    public Library(Book... books) {
        this.books = books;
    }

    private final class LibIterator implements Iterator<Book> { // <- Iterator

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
        return new LibIterator();
    }

}
