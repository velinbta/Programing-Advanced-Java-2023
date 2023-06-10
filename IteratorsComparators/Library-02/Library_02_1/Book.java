package Library_02_1;

import java.util.Arrays;
import java.util.stream.Collectors;

// class Book
public class Book {

    private String title;
    private int year;
    private String[] authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = authors;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getAuthors() {

        if (this.authors.length > 0)
            return Arrays.stream(this.authors).collect(Collectors.joining(", "));

        return "n\\a";
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Year: %d, Authors: %s", getTitle(), getYear(),
                getAuthors());
    }

}
