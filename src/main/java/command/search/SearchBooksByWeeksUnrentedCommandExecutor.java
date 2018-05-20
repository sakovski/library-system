package command.search;

import book.Book;
import book.BookService;
import command.CommandExecutor;
import report.SearchReportService;

import java.util.List;

public class SearchBooksByWeeksUnrentedCommandExecutor implements CommandExecutor {

    private final SearchBookArgumentReader searchBookArgumentReader = new SearchBookArgumentReader();
    private final SearchBooksByWeeksUntrentedArgumentParser searchBooksByWeeksUntrentedArgumentParser = new SearchBooksByWeeksUntrentedArgumentParser();
    private final BookService bookService = new BookService();
    private final SearchReportService searchReportService = new SearchReportService();

    @Override
    public void execute() {
        System.out.println("Weeks:");
        String userInput = searchBookArgumentReader.readArgumentsFromUser();
        int weeks = searchBooksByWeeksUntrentedArgumentParser.parseUserInput(userInput);
        List<Book> foundBooks = bookService.getBooksByWeeksUntrented(weeks);
        searchReportService.printSearchReport(foundBooks);
    }
}
