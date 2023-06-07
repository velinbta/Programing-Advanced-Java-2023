1. Book
Create a class Book from the UML diagram below:

Book
- title: String
- year: int
- authors: List<String> 
- setTitle(String)
- setYear(int)
- setAuthors(String...)
+ getTitle(): String
+ getYear(): int
+ getAuthors(): List<String>
You can use only one constructor. There can be no authors, one author, or many authors. 

Examples:

    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

    }
