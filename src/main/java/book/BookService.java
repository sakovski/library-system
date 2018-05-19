package book;

import java.util.List;
import java.util.Optional;

public class BookService {

    public static final String NO_FOUND_ERROR_MESSAGE = "There is no book '%s' in the library.";

    private final BookRepository bookRepository = new BookRepository();
    private final BookFactory bookFactory = new BookFactory();

    public void addToRepository(String title, String author, String isbnNumber) {
        Book newBook = bookFactory.createBook(title, author, isbnNumber);
        bookRepository.save(newBook);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> findBookByIsbn(String isbn) {
        return bookRepository.findBooksByIsbn(isbn);
    }

    /*
    public void removeFromRepository(String title, String isbnNumber) {
        Book bookToRemove = bookRepository.findByIsbnNumber(isbnNumber)
                .orElseThrow(() -> new RuntimeException(String.format(NO_FOUND_ERROR_MESSAGE, title)));
        bookRepository.remove(bookToRemove);
    }
    */
}
