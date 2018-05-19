package command.rent;

import book.Book;
import book.BookService;
import command.CommandExecutor;
import command.add.AddDeleteBookArguments;
import command.add.AddDeleteBookArgumentsReader;
import library_user.LibraryUser;
import library_user.LibraryUserService;

public class RentBookCommandExecutor implements CommandExecutor {

    private final LibraryUserService libraryUserService = new LibraryUserService();
    private final BookService bookService = new BookService();
    private final AddDeleteBookArgumentsReader addDeleteBookArgumentsReader = new AddDeleteBookArgumentsReader();
    private final LibraryUserPropertiesReader libraryUserPropertiesReader = new LibraryUserPropertiesReader();

    @Override
    public void execute() {
        System.out.println("*Rent Book*");
        AddDeleteBookArguments searchBookArguments = addDeleteBookArgumentsReader.readArgumentsFromUser();
        Book bookCandidate = bookService.getOneBookByProperties(searchBookArguments.getTitle(), searchBookArguments.getAuthor(), searchBookArguments.getIsbnNumber());
        System.out.println("Available book found! Give user data:");
        LibraryUser userCandidate = libraryUserPropertiesReader.readArgumentsFromUser();
        libraryUserService.saveBookForLibraryUser(userCandidate, bookCandidate);
        bookService.setBookAsRentedWithUser(userCandidate, bookCandidate);
    }
}
