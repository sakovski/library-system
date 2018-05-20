package report;

import book.Book;

import java.util.List;

public class SingleUserBooksReportService {

    public static final String BOOKS_FOUND = "Books found: %s";

    private final SearchReportService searchReportService = new SearchReportService();

    public void printUserReport(List<Book> books) {
        searchReportService.printSearchReport(books);
    }

}
