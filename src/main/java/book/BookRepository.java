package book;

import libraryuser.LibraryUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookRepository {

    public static final List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public List<Book> findBooksInRepositoryByProperties(String title, String author, String isbnNumber) {
        return books.stream()
                .filter(i -> i.getIsbnNumber().equals(isbnNumber))
                .filter(i -> i.getAuthor().equals(author))
                .filter(i -> i.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByIsbn(String isbnNumber) {
        return books.stream()
                .filter(b -> b.getIsbnNumber().equals(isbnNumber))
                .collect(Collectors.toList());
    }

}
