package book;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {

    private static final List<Book> books = new ArrayList<>();

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
                .filter(b -> b.getAuthor().contains(author))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByIsbn(String isbnNumber) {
        return books.stream()
                .filter(b -> b.getIsbnNumber().contains(isbnNumber))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByWeeksUnrented(int weeks) {
        return books.stream()
                .filter(b -> ChronoUnit.WEEKS.between(b.getDateLastRent(), LocalDateTime.now()) >= weeks)
                .collect(Collectors.toList());
    }
}
