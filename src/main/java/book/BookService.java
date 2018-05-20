package book;

import library_user.LibraryUser;

import java.time.LocalDate;
import java.util.List;

public class BookService {

    public static final String NO_FOUND_ERROR_MESSAGE = "Book with Title: %s,  Author: %s not found!";
    public static final String NO_BOOKS_AVAILABLE_MESSAGE = "No Book with Title: %s,  Author: %s is available now!";

    private final BookRepository bookRepository = new BookRepository();
    private final BookFactory bookFactory = new BookFactory();

    public void addNewBookToRepository(String title, String author, String isbnNumber) {
        Book newBook = bookFactory.createBook(title, author, isbnNumber);
        bookRepository.save(newBook);
    }

    public Book addBookFromFileToRepository(String title, String author, String isbnNumber, boolean isRented, LibraryUser lastUser, LocalDate dateLastRented) {
        Book newBook = bookFactory.createExistingBook(title, author, isbnNumber, isRented, lastUser, dateLastRented);
        bookRepository.save(newBook);
        return newBook;
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

    public Book getOneBookByProperties(String title, String author) {
        List<Book> booksCandidates = bookRepository.findBooksInRepositoryByProperties(title, author);
        if(booksCandidates.size() == 0) {
            throw new RuntimeException(String.format(NO_FOUND_ERROR_MESSAGE, title, author));
        }
        return booksCandidates.stream()
                .filter(b -> !b.isRented)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format(NO_BOOKS_AVAILABLE_MESSAGE, title, author)));
    }

    public void removeFromRepository(String title, String author, String isbnNumber) {
        List<Book> bookToRemove = bookRepository.findBooksInRepositoryByProperties(title, author);
        if(bookToRemove.size() == 0)
            throw new RuntimeException(String.format(NO_FOUND_ERROR_MESSAGE, title, author, isbnNumber));
        bookToRemove.stream()
                .filter(b -> !b.isRented)
                .filter(b -> b.getIsbnNumber().equals(isbnNumber))
                .forEach(b -> bookRepository.remove(b));
    }

    public void setBookAsRentedWithUser(LibraryUser libraryUser, Book book) {
        book.setCurrentLibraryUser(libraryUser);
        book.setDateLastRent(LocalDate.now());
        book.isRented = true;
    }

    public List<Book> getBooksByWeeksUntrented(int weeks) {
        return bookRepository.findBooksByWeeksUnrented(weeks);
    }
}
