2. Library

Create a class Book from the UML diagram below:

Book
- title: String
- year: int
- authors: String[]
+ getTitle(): String
+ getYear(): int
+ getAuthors(): String
You can use only one constructor. There can be no authors, one author, or many authors.

Create a class Library from the UML diagram below:

<<Iterable<Book>>>
Library
- books: Book[]
- iterator(): Iterator<Book>

Create a nested class LibIterator from the UML diagram below:
<<Iterator<Book>>>
LibIterator
- counter: int
+ hasNext(): boolean
+ next(): Book

Examples:

    public static void main(String[] args) {
        
        Book firstBook = new Book("Animal Farm", 2003, "George Orwell");
        Book secondBook = new Book("The Documents in the Case", 2002);
        Book thirdBook = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(firstBook, secondBook, thirdBook);

        for (Book book : library) {
            System.out.println(book.getTitle());
        }

    }
