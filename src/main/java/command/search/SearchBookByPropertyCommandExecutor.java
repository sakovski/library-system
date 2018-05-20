package command.search;

import book.Book;
import book.BookService;
import command.CommandExecutor;
import report.SearchReportService;

import java.util.List;

public class SearchBookByPropertyCommandExecutor implements CommandExecutor {

    public static final String INFO_MESSAGE = "*Search book by property: %s<title> or %s<author> or %s<ISBN number>*";
    public static final String TITLE_PREFIX = "-T";
    public static final String AUTHOR_PREFIX = "-A";
    public static final String ISBN_PREFIX = "-I";

    private final BookService bookService = new BookService();
    private final SearchBookArgumentReader searchBookArgumentReader = new SearchBookArgumentReader();
    private final SearchBookByPropertyArgumentsParser searchBookByPropertyArgumentsParser = new SearchBookByPropertyArgumentsParser();
    private final SearchReportService searchReportService = new SearchReportService();

    @Override
    public void execute() {
        System.out.println(String.format(INFO_MESSAGE, TITLE_PREFIX, AUTHOR_PREFIX, ISBN_PREFIX));
        String argument = searchBookArgumentReader.readArgumentsFromUser();
        SearchBookByPropertyArgument searchBookByPropertyArgument = searchBookByPropertyArgumentsParser.parseUserArgument(argument);
        if(searchBookByPropertyArgument.getPrefix().equals(TITLE_PREFIX)) {
            List<Book> foundBooks = bookService.findBookByTitle(searchBookByPropertyArgument.getArgument());
            searchReportService.printSearchReport(foundBooks);
        }
        if(searchBookByPropertyArgument.getPrefix().equals(AUTHOR_PREFIX)) {
            List<Book> foundBooks = bookService.findBookByAuthor(searchBookByPropertyArgument.getArgument());
            searchReportService.printSearchReport(foundBooks);
        }
        if(searchBookByPropertyArgument.getPrefix().equals(ISBN_PREFIX)) {
            List<Book> foundBooks = bookService.findBookByIsbn(searchBookByPropertyArgument.getArgument());
            searchReportService.printSearchReport(foundBooks);
        }
    }
}
