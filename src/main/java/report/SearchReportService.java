package report;

import book.Book;

import java.util.List;

public class SearchReportService {

    public static final String BOOKS_FOUND = "Books found: %s";
    public static final String BOOK_INFO = "Title: %s, Author: %s, ISBN number: %s, Last rented: %s, Last user: %s, Is available: %s";

    public void printSearchReport(List<Book> books) {
        System.out.println(String.format(BOOKS_FOUND, books.size()));
        if(books.size() > 0) {
            books.stream()
            .forEach(b -> printBookInfo(b));
        }
    }

    private void printBookInfo(Book book) {
        System.out.println(String.format(BOOK_INFO,
                book.getTitle(),
                book.getAuthor(),
                book.getIsbnNumber(),
                book.getDateLastRent(),
                getCurrentLibraryUserToReport(book),
                isBookavailableToReport(book)));
    }

    private String isBookavailableToReport(Book book) {
        if(book.isRented) {
            return "No";
        }
        return "Yes";
    }

    private String getCurrentLibraryUserToReport(Book book) {
        if(book.getCurrentLibraryUser() == null) {
            return "NONE";
        }
        return book.getCurrentLibraryUser().getFullInfo();
    }
}
