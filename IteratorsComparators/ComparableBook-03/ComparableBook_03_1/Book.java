package ComparableBook_03_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// class Book
public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public int compareTo(Book other) {
        // По заглавие на книгата
        if (getTitle().compareTo(other.getTitle()) < 0)
            return -1;
        else if (getTitle().compareTo(other.getTitle()) > 0)
            return 1;

        return Integer.compare(getYear(), other.getYear()); // <- Ако са равни по година

    }

    @Override
    public String toString() {

        if (getAuthors().isEmpty())
            return String.format("Title: %s, Year: %d, Authors: n\\a", getTitle(), getYear());
        else
            return String.format("Title: %s, Year: %d, Authors: %s", getTitle(), getYear(),
                    getAuthors().stream().collect(Collectors.joining(", ")));

    }

}
