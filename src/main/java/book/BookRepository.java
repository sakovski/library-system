package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
