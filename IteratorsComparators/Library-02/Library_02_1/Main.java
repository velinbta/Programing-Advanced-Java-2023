package Library_02_1;

public class Main {
    public static void main(String[] args) {

        Book firstBook = new Book("Animal Farm", 2003, "George Orwell");
        Book secondBook = new Book("The Documents in the Case", 2002);
        Book thirdBook = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(firstBook, secondBook, thirdBook); // <- Iterable Library

        for (Book book : library) {
            System.out.println(book.getTitle());
        }

    }

}
