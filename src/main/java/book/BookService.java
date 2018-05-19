package book;

import libraryuser.LibraryUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookService {

    public static final String NO_FOUND_ERROR_MESSAGE = "Book with Title: %s,  Author: %s,  ISBN number: %s not found!";
    public static final String NO_BOOKS_AVAILABLE_MESSAGE = "No Book with Title: %s,  Author: %s,  ISBN number: %s is available now!";

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

    public Book getOneBookByProperties(String title, String author, String isbnNumber) {
        List<Book> booksCandidates = bookRepository.findBooksInRepositoryByProperties(title, author, isbnNumber);
        if(booksCandidates.size() == 0) {
            throw new RuntimeException(String.format(NO_FOUND_ERROR_MESSAGE, title, author, isbnNumber));
        }
        return booksCandidates.stream()
                .filter(b -> !b.isRented)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format(NO_BOOKS_AVAILABLE_MESSAGE, title, author, isbnNumber)));
    }

    public void removeFromRepository(String title, String author, String isbnNumber) {
        List<Book> bookToRemove = bookRepository.findBooksInRepositoryByProperties(title, author, isbnNumber);
        if(bookToRemove.size() == 0)
            throw new RuntimeException(String.format(NO_FOUND_ERROR_MESSAGE, title, author, isbnNumber));
        bookToRemove.stream()
                .filter(b -> !b.isRented)
                .forEach(b -> bookRepository.remove(b));
    }

    public void setBookAsRentedWithUser(LibraryUser libraryUser, Book book) {
        book.setCurrentLibraryUser(libraryUser);
        book.setDateLastRent(LocalDate.now());
        book.isRented = true;
    }
}
