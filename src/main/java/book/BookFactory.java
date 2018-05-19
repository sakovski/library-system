package book;

public class BookFactory {
    private final IsbnValidator isbnValidator = new IsbnValidator();

    public Book createBook(String title, String author, String isbnNumber) {
        if(isbnValidator.isIsbnNumberValid(isbnNumber)) {
            System.out.println("Book created!");
            return new Book(title, author, isbnNumber);
        }
        throw new RuntimeException("Given ISBN number is not valid!");
    }
}
