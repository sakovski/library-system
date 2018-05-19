package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookRepository {

    public static final List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
        printBoooks();
    }

    private void printBoooks() { //ONLY TO DEBUG!
        books.stream()
                .forEach(b -> System.out.print(b.getAuthor() + ";" + b.getTitle() + ";" + b.getIsbnNumber() + System.lineSeparator()));
       // System.out.print(books.get(0).getTitle() + books.get(0).getAuthor() + books.get(0).getIsbnNumber());
    }


    public void remove(Book book) {
        books.remove(book);
    }

    public Optional<Book> findBookInRepository(String title, String author, String isbnNumber) {
        return books.stream()
                .filter(i -> i.getIsbnNumber().equals(isbnNumber)) //TODO: TO CHANGE
                .findFirst();
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
