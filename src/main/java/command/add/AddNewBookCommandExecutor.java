package command.add;

import book.BookService;
import command.CommandExecutor;

import java.util.List;

public class AddNewBookCommandExecutor implements CommandExecutor {

    private final AddNewBookArgumentsReader addNewBookArgumentsReader = new AddNewBookArgumentsReader();
    private final BookService bookService = new BookService();

    @Override
    public void execute(String command) {
        System.out.println("*New book creator*");
        BookArguments bookArguments = addNewBookArgumentsReader.readArgumentsFromUser();
        bookService.addToRepository(bookArguments.getTitle(), bookArguments.getAuthor(), bookArguments.getIsbnNumber());
    }
}
