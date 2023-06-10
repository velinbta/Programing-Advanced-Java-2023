3. Comparable Book
Expand Book by implementing Comparable<Book>.
The book has to be compared by title. When the title is equal, compare them by year.

Expand Book from UML diagram below:
<<Comparable<Book>>>
Book
- title: String
- year: int
- authors: List<String> 
- setTitle(String)
- setYear(String)
- setAuthors(String...)
+ getTitle(): String
+ getYear(): int
+ getAuthors(): List<String>
+ compareTo(Book): int

You can use only one constructor. There can be no authors, one author, or many authors. 

Examples:

  public static void main(String[] args) {

        Book firstBook = new Book("Animal Farm", 2003, "George Orwell");
        Book secondBook = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book thirdBook = new Book("The Documents in the Case", 2002);

        boolean fixMe = false;

        if (firstBook.compareTo(secondBook) < 0) {
            System.out.printf("%s is before %s.\n", firstBook.getTitle(), secondBook.getTitle());
        } else {
            fixMe = true;
        }

        if (secondBook.compareTo(firstBook) > 0) {
            System.out.printf("%s is after %s.\n", secondBook.getTitle(), firstBook.getTitle());
        } else {
            fixMe = true;
        }

        if (secondBook.compareTo(thirdBook) < 0) {
            System.out.printf("%s and %s are equal, but %d is before %d.\n",
                    secondBook.getTitle(), thirdBook.getTitle(), secondBook.getYear(), thirdBook.getYear());
        } else {
            fixMe = true;
        }

        if (fixMe) {
            System.out.println("FIX ME");
        }

    }