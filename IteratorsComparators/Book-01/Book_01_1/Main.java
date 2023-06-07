package Book_01_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Добавя и принтира въведените книги
        Book firstBook = new Book("Animal Farm", 2003, "George Orwell");
        Book secondBook = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book thirdBook = new Book("The Documents in the Case", 2002);

        List<Book> books = new ArrayList<>(Arrays.asList(firstBook, secondBook, thirdBook));
        books.forEach(System.out::println);

    }

}
