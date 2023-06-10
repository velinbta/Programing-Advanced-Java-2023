package BookComparator_04_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book firstBook = new Book("Animal Farm", 2003, "George Orwell");
        Book secondBook = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book thirdBook = new Book("The Documents in the Case", 2002);

        List<Book> books = new ArrayList<>();
        books.add(secondBook);
        books.add(thirdBook);
        books.add(firstBook);

        // По заглавие, ако са равни - по година на издаване
        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.printf("%s %d\n", book.getTitle(), book.getYear());
        }

    }

}
