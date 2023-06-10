package BookComparator_04_1;

import java.util.Comparator;

// Comparator<Book>
public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
        // По заглавие
        if (first.getTitle().compareTo(second.getTitle()) < 0)
            return -1;
        else if (first.getTitle().compareTo(second.getTitle()) > 0)
            return 1;

        return Integer.compare(first.getYear(), second.getYear()); // <- Ако са равни - по година на издаване
    }

}
