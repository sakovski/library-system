package book;

import reader.Reader;

import java.time.LocalDate;

public class Book {

    private final String title;
    private final String author;
    private final String isbnNumber;
    private final LocalDate dateLastRent;
    private final Reader currentReader;

    public Book(String title, String author, String isbnNumber) {
        this.title = title;
        this.author = author;
        this.isbnNumber = isbnNumber;
        dateLastRent = null;
        currentReader = null;
    }
}
