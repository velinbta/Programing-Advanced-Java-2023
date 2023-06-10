4. Book Comparator
Create a class Book from the UML diagram below:

Book
- title: String
- year: int
- authors: String[]
+ getTitle(): String
+ getYear(): int
+ getAuthors(): String
You can use only one constructor. There can be no authors, one author, or many authors.

Create a class BookComparator from the UML diagram below: 
<<Comparator<Book>>>
BookComparator
+ compare(Book, Book): int
BookComparator has to compare two books by:
1. Book title.
2. Year of publishing a book.

Examples:

    public static void main(String[] args) {

        Book firstBook = new Book("Animal Farm", 2003, "George Orwell");
        Book secondBook = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book thirdBook = new Book("The Documents in the Case", 2002);

        List<Book> books = new ArrayList<>();
        books.add(secondBook);
        books.add(thirdBook);
        books.add(firstBook);

        books.sort(new BookComparator());

        for (Book book: books) {
            System.out.printf("%s %d\n", book.getTitle(), book.getYear());
        }

    }