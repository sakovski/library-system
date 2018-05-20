package command.return_book;

import book.Book;
import book.BookService;
import command.CommandExecutor;
import command.rent.LibraryUserPropertiesReader;
import library_user.LibraryUser;
import library_user.LibraryUserService;
import report.SingleUserBooksReportService;

import java.util.List;

public class ReturnBookCommandExecutor implements CommandExecutor {

    private final LibraryUserService libraryUserService = new LibraryUserService();
    private final BookService bookService = new BookService();
    private final ReturnBookArgumentReader returnBookArgumentsReader = new ReturnBookArgumentReader();
    private final LibraryUserPropertiesReader libraryUserPropertiesReader = new LibraryUserPropertiesReader();
    private final SingleUserBooksReportService singleUserBooksReportService = new SingleUserBooksReportService();

    @Override
    public void execute() {
        System.out.println("*Return Book*");
        LibraryUser userCandidate = libraryUserPropertiesReader.readArgumentsFromUser();
        LibraryUser libraryUser = libraryUserService.getUserFromRepository(userCandidate.getFirstname(), userCandidate.getLastname())
                .orElseThrow(() -> new RuntimeException("User doesnt exist!"));

        List<Book> booksOfUser = bookService.getBooksOfUser(libraryUser);
        singleUserBooksReportService.printUserReport(booksOfUser);

        int userChoice = returnBookArgumentsReader.getUserInput();
        if(userChoice > booksOfUser.size()) {
            throw new RuntimeException("Wrong book index: " + userChoice);
        }

        Book chosenBook = booksOfUser.get(userChoice - 1);
        chosenBook.isRented = false;
        libraryUser.getRentedBooks().remove(chosenBook);

        System.out.println("Book returned!");
    }
}
